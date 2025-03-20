package com.websocket;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://tripadvisor16.p.rapidapi.com/api/v1/restaurant/searchRestaurants?locationId=304554")
                .header("x-rapidapi-key", "fe3a1f1a3amsh46f5e6d45098fa9p1f1187jsn3baf096d01d6")
                .header("x-rapidapi-host", "tripadvisor16.p.rapidapi.com")
                .asString();

        System.out.println(response.getBody());
    }
}
