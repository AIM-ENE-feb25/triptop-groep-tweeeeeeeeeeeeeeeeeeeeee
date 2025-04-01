package nl.han.soex.twee.prototype.controller;

import nl.han.soex.twee.prototype.service.AdviceService;
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
@RequestMapping("/advice")
public class AdviceController {

    private final AdviceService adviceService;

    @Autowired
    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @GetMapping("/cheapest")
    public ResponseEntity getCheapestListings() {

        adviceService.generateAdvice(new CheapestAdviceStrategy());

        return ResponseEntity.status(HttpStatus.OK).body("a"/*return listings*/);
    }

    @GetMapping("/priciest")
    public ResponseEntity getPriciestListings() {

        adviceService.generateAdvice(new PriciestAdviceStrategy());

        return ResponseEntity.status(HttpStatus.OK).body("b"/*return listings*/);
    }
}
