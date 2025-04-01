package nl.han.soex.twee.prototype.service.AdviceStrategies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PriciestAdviceStrategy extends AdviceStrategy {

    @Override
    public String generateAdvice() {
        try {
            // API URL
            URL url = new URL("https://airbnb19.p.rapidapi.com/api/v1/searchPropertyByLocationV2?location=london&totalRecords=10&currency=USD&adults=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            conn.setRequestProperty("x-rapidapi-key", "0166b08242msh8abe465de914eecp1d9efbjsn3c2279e391f2");
            conn.setRequestProperty("x-rapidapi-host", "airbnb19.p.rapidapi.com");

            // Read the response
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse JSON response
                parseAndPrintTopListings(response.toString());
            } else {
                System.out.println("HTTP Request Failed. Response Code: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void parseAndPrintTopListings(String jsonResponse) {
        try {
            // Parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode list = rootNode.path("data").path("list");

            if (list.isArray()) {
                // Print top 3 listings
                for (int i = 0; i < Math.min(4, list.size()); i++) {
                    JsonNode listingNode = list.get(i).path("listing");
                    String name = listingNode.path("name").asText("N/A");
                    String price = list.get(i).path("pricingQuote").path("structuredStayDisplayPrice").path("primaryLine").path("price").asText("N/A");
                    String url = listingNode.path("url").asText("N/A");

                    System.out.println("Listing #" + (i + 1));
                    System.out.println("Name: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("URL: " + url);
                    System.out.println("-------------------------");
                }
            } else {
                System.out.println("No listings found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
