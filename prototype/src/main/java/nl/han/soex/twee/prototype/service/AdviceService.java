package nl.han.soex.twee.prototype.service;

import nl.han.soex.twee.prototype.service.AdviceStrategies.AdviceStrategy;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {
    public void generateAdvice(AdviceStrategy adviceStrategy){
        adviceStrategy.generateAdvice();
    }
}
