package nl.han.soex.twee.prototype.service.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.han.soex.twee.prototype.domain.TrainTrip;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class NsApiClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public List<TrainTrip> getTrainTrips(String fromStation, String toStation) {
        List<TrainTrip> trainTrips = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gateway.apiportal.ns.nl/reisinformatie-api/api/v3/trips?fromStation=%S&toStation=%S".formatted(fromStation, toStation)))
                .header("Ocp-Apim-Subscription-Key", "ef0f39f29f11412ba55d7342cd79b992")
                .build();

        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return parseTrainTrips(response.body());
    }

    private List<TrainTrip> parseTrainTrips(String json) {
        List<TrainTrip> trainTrips = new ArrayList<TrainTrip>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode trips = objectMapper.readTree(json).get("trips");

            for (JsonNode trip : trips) {
                double price = 0;

                for (JsonNode fare : trip.get("fares")) {
                    boolean isOneWay = "OVCHIPKAART_ENKELE_REIS".equals(fare.get("product").asText());
                    boolean isSecondClass = "SECOND_CLASS".equals(fare.get("travelClass").asText());
                    boolean hasNoDiscount = "NO_DISCOUNT".equals(fare.get("discountType").asText());

                    if (isOneWay && isSecondClass && hasNoDiscount) {
                        price = fare.get("priceInCents").asDouble() / 100;
                        break;
                    }
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

                String plannedDepartureString = trip.get("legs").get(0).get("origin").get("plannedDateTime").asText();
                OffsetDateTime plannedDepartureDateTime = OffsetDateTime.parse(plannedDepartureString, formatter);

                String plannedArrivalString = trip.get("legs").get(0).get("destination").get("plannedDateTime").asText();
                OffsetDateTime plannedArrivalDateTime = OffsetDateTime.parse(plannedArrivalString, formatter);

                trainTrips.add(new TrainTrip(price, plannedDepartureDateTime, plannedArrivalDateTime));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(trainTrips);
    }
}