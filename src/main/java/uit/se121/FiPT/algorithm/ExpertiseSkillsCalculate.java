package uit.se121.FiPT.algorithm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se121.FiPT.dto.CalculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.E_Score.ExpertiseSkillJobDto;
import uit.se121.FiPT.dto.CalculateParameter.E_Score.MajorExpertiseSkillDto;


@Component
@RequiredArgsConstructor
public class ExpertiseSkillsCalculate {
    private int weight;

    public ExpertiseSkillCalculateDto calculateScore(ExpertiseSkillJobDto jobSkillDto, MajorExpertiseSkillDto majorDto) {
        int score1 = (jobSkillDto.getSkillName1().equals(majorDto.getExSkill1())) ? jobSkillDto.getExpertiseSkill1() * weight : weight;
        int score2 = (jobSkillDto.getSkillName2().equals(majorDto.getExSkill2())) ? jobSkillDto.getExpertiseSkill2() * weight : weight;
        int score3 = (jobSkillDto.getSkillName3().equals(majorDto.getExSkill3())) ? jobSkillDto.getExpertiseSkill3() * weight : weight;
        int sumScore = score1 + score2 + score3;

        return ExpertiseSkillCalculateDto.builder()
                .expertiseSkill1(score1)
                .expertiseSkill2(score2)
                .expertiseSkill3(score3)
                .totalValue(sumScore)
                .build();
    }
}
