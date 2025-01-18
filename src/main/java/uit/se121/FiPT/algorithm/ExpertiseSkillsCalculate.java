package uit.se121.FiPT.algorithm;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillJobDto;
import uit.se121.FiPT.dto.calculateParameter.E_Score.MajorExpertiseSkillDto;


@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class ExpertiseSkillsCalculate {
    private double weight;

    public ExpertiseSkillCalculateDto calculateScore(ExpertiseSkillJobDto jobSkillDto, MajorExpertiseSkillDto majorDto) {
        double score1 = (jobSkillDto.getSkillName1().equals(majorDto.getExSkill1())) ? jobSkillDto.getExpertiseSkill1() * weight : weight;
        double score2 = (jobSkillDto.getSkillName2().equals(majorDto.getExSkill2())) ? jobSkillDto.getExpertiseSkill2() * weight : weight;
        double score3 = (jobSkillDto.getSkillName3().equals(majorDto.getExSkill3())) ? jobSkillDto.getExpertiseSkill3() * weight : weight;
        double sumScore = score1 + score2 + score3;

        return ExpertiseSkillCalculateDto.builder()
                .expertiseSkill1(score1)
                .expertiseSkill2(score2)
                .expertiseSkill3(score3)
                .totalValue(sumScore)
                .build();
    }
}
