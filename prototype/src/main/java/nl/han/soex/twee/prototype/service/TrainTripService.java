package nl.han.soex.twee.prototype.service;

import nl.han.soex.twee.prototype.domain.TrainTrip;
import nl.han.soex.twee.prototype.service.external.NsApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTripService {

    @Autowired
    private NsApiClient nsApiClient;

    public List<TrainTrip> getTrainTrips(String fromStation, String toStation) {
        return nsApiClient.getTrainTrips(fromStation, toStation);
    }



//    zoek codes met stations



//    zoek routes met code

//    geef top drie 1
}
