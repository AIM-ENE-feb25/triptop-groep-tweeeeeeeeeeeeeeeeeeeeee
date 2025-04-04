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

    @Autowired
    @Qualifier("deutscheBahnAdapter")
    private ITravelAdapter deutscheBahnAdapter;
    public String getTravelData(String locationStart, String locationEnd, String transportType) throws UnirestException {
        switch (transportType) {
            case "CAR":
                return drivingDirectionAdapter.getRoute(locationStart, locationEnd);
            case "TRAIN":
               return deutscheBahnAdapter.getRoute(locationStart, locationEnd);
                default:
                throw new IllegalArgumentException("Unsupported travel type: " + transportType);
        }
    }
}
