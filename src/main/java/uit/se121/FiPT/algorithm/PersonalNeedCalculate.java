package uit.se121.FiPT.algorithm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonalNeed {
    private int weight;

    public int calculateWageScore(int Wage) {
        if (Wage < 25000) return 1;
        else if (Wage <= 50000) return 2;
        else if (Wage <= 80000) return 3;
        else if (Wage <= 120000) return 4;
        return 5;
    }

    
}
