package nl.han.soex.twee.prototype.service;

import nl.han.soex.twee.prototype.domain.Accommodation;
import nl.han.soex.twee.prototype.service.AdviceStrategies.AdviceStrategy;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService {
    public Accommodation[] generateAdvice(AdviceStrategy adviceStrategy){
        return adviceStrategy.generateAdvice();
    }
}
