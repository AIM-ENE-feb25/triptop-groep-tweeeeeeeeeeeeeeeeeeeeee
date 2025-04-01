package nl.han.soex.twee.prototype.controller;

import nl.han.soex.twee.prototype.domain.TrainTrip;
import nl.han.soex.twee.prototype.service.TrainTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("traintrip")
public class TrainTripController {

    @Autowired
    private TrainTripService trainTripService;

    @GetMapping
    public ResponseEntity<List<TrainTrip>> getTrainTrips(
            @RequestParam(defaultValue = "NM") String fromStation,
            @RequestParam(defaultValue = "AH") String toStation) {

        List<TrainTrip> trainTrips = trainTripService.getTrainTrips(fromStation, toStation);

        return ResponseEntity.ok(trainTrips);
    }
}
