package nl.han.soex.twee.prototype.service.Adapter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("deutscheBahnAdapter")
public class DeutscheBahnAdapter implements ITravelAdapter {

    @Override
    public String getRoute(String locationStart, String locationEnd) throws UnirestException {
    return "Uitwerking deutsche bahn";
    }
}