package nl.han.soex.twee.prototype.service.Adapter;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface ITravelAdapter {

    String getRoute(String locationStart, String locationEnd) throws UnirestException;
}
