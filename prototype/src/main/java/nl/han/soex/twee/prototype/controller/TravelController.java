package nl.han.soex.twee.prototype.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import nl.han.soex.twee.prototype.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/travel")
public class TravelController {


    private TravelService travelService;

    @Autowired
    private TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/traveldata")
    public String getTravelData(@RequestParam String locationStart
            , @RequestParam String locationEnd, @RequestParam String transportType) throws UnirestException {


        return travelService.getTravelData(locationStart, locationEnd, transportType);
    }
}
