package nl.han.soex.twee.prototype.service.Adapter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("drivingDirectionAdapter")
public class DrivingDirectionAdapter implements ITravelAdapter{

    @Override
    public String getRoute(String locationStart, String locationEnd) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://driving-directions1.p.rapidapi.com/get-directions?" + "origin=" + locationStart + "&destination=" + locationEnd)
                .header("Content-Type", "application/json")
                .header("X-RapidAPI-Key", "96c5f5a0f3msh929cfe13a11db73p1c5ad2jsnc5f174407d9a")
                .header("X-RapidAPI-Host", "driving-directions1.p.rapidapi.com")
                .asJson();

        StringBuilder res = new StringBuilder();

        JSONObject jsonObject = response.getBody().getObject();
        JSONObject data = jsonObject.getJSONObject("data");
        JSONObject origin = data.getJSONObject("origin");
        JSONObject destination = data.getJSONObject("destination");
        JSONArray bestRoutes = data.getJSONArray("best_routes");

        if (bestRoutes.length() > 0){
            JSONObject bestRoute = bestRoutes.getJSONObject(0);
            String distanceLabel = bestRoute.getString("distance_label");
            String durationLabel = bestRoute.getString("duration_label");

            res.append(String.format("Origin: %s, Destination: %s, Distance: %s, Duration: %s",
                    origin.getString("name"), destination.getString("name"), distanceLabel, durationLabel));
        }else {
            res.append("No routes found.");
        }

        return res.toString();
    }
}
