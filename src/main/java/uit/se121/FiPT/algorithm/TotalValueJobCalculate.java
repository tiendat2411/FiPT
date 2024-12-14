package uit.se121.FiPT.algorithm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se121.FiPT.dto.CalculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.S_Score.SoftSkillCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.TotalValueJobDto;

@Component
@RequiredArgsConstructor
public class TotalValueJobCalculate {
    public TotalValueJobDto calculateTotalValueJob(SoftSkillCalculateDto sScore, ExpertiseSkillCalculateDto eScore, PersonalNeedCalculateDto nScore) {
        return TotalValueJobDto.builder()
                .sScore(sScore)
                .eScore(eScore)
                .nScore(nScore)
                .totalSocre(sScore.getTotalValue() + eScore.getTotalValue() + nScore.getTotalValue())
                .build();
    }
}
