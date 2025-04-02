package nl.han.soex.twee.prototype.controller;

import nl.han.soex.twee.prototype.domain.Accommodation;
import nl.han.soex.twee.prototype.service.AccommodationService;
import nl.han.soex.twee.prototype.service.AdviceStrategies.CheapestAdviceStrategy;
import nl.han.soex.twee.prototype.service.AdviceStrategies.PriciestAdviceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService adviceService) {
        this.accommodationService = adviceService;
    }

    @GetMapping("/cheapest")
    public ResponseEntity<Accommodation[]> getCheapestListings() {
        return ResponseEntity.status(HttpStatus.OK).body(accommodationService.generateAdvice(new CheapestAdviceStrategy()));
    }

    @GetMapping("/priciest")
    public ResponseEntity<Accommodation[]> getPriciestListings() {
        return ResponseEntity.status(HttpStatus.OK).body(accommodationService.generateAdvice(new PriciestAdviceStrategy()));
    }
}
