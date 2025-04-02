package nl.han.soex.twee.prototype.service.AdviceStrategies;

import nl.han.soex.twee.prototype.domain.Accommodation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PriciestAdviceStrategy extends AdviceStrategy {

    @Override
    public Accommodation[] generateAdvice() {
        Accommodation[] accoArray = new Accommodation[0];

        try {
            HttpURLConnection connection = getHttpURLConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray hotels = jsonResponse.getJSONObject("data").getJSONArray("hotels");
                if (hotels.length() >= 3) {
                    accoArray = new Accommodation[3];

                    for (int i = hotels.length() - 1; i > hotels.length() - 4; i--) {
                        JSONObject hotel = hotels.getJSONObject(i);
                        int hotelId = hotel.getInt("hotel_id");
                        JSONObject priceObj = hotel.getJSONObject("property").getJSONObject("priceBreakdown").getJSONObject("grossPrice");
                        double price = priceObj.getDouble("value");
                        String currency = priceObj.getString("currency");

                        Accommodation a = new Accommodation(hotelId, price, currency);

                        accoArray[hotels.length() - 1 - i] = a;

                        System.out.println("Hotel ID: " + hotelId + ", Price: " + price + currency);
                    }
                } else {
                    accoArray = new Accommodation[hotels.length()];

                    for (int i = hotels.length(); i > 0; i--) {
                        JSONObject hotel = hotels.getJSONObject(i);
                        int hotelId = hotel.getInt("hotel_id");
                        JSONObject priceObj = hotel.getJSONObject("property").getJSONObject("priceBreakdown").getJSONObject("grossPrice");
                        double price = priceObj.getDouble("value");
                        String currency = priceObj.getString("currency");

                        Accommodation a = new Accommodation(hotelId, price, currency);

                        accoArray[hotels.length() - i] = a;

                        System.out.println("Hotel ID: " + hotelId + ", Price: " + price + currency);
                    }
                }
            } else {
                System.out.println("GET request failed: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accoArray;
    }

    private static HttpURLConnection getHttpURLConnection() throws IOException {
        URL url = new URL("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels?dest_id=-2092174&search_type=CITY&arrival_date=2025-04-10&departure_date=2025-04-24&sort_by=price&units=metric&temperature_unit=c&languagecode=en-us&currency_code=USD&location=US");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-rapidapi-key", "96c5f5a0f3msh929cfe13a11db73p1c5ad2jsnc5f174407d9a");
        connection.setRequestProperty("x-rapidapi-host", "booking-com15.p.rapidapi.com");
        return connection;
    }
}