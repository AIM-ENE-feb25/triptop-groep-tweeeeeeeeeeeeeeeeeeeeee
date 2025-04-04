package nl.han.soex.twee.prototype.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import nl.han.soex.twee.prototype.service.Adapter.ITravelAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

@Service
public class TravelService {

    @Autowired
    @Qualifier("drivingDirectionAdapter") // first letter cannot be capital
    private ITravelAdapter drivingDirectionAdapter;

    public String getTravelData(String locationStart, String locationEnd, String transportType) throws UnirestException {
        switch (transportType) {
            case "CAR":
                return drivingDirectionAdapter.getRoute(locationStart, locationEnd);
            case "TRAIN":
               return "Train not yet implemented";
                default:
                throw new IllegalArgumentException("Unsupported travel type: " + transportType);
        }
    }
}
