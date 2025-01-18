package uit.se121.FiPT.algorithm;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillJobDto;
import uit.se121.FiPT.entity.Major;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class SoftSkillsCalculate {
    private double weight;

    public SoftSkillCalculateDto calculateScore(Major major, SoftSkillJobDto softSkillDto) {
        return SoftSkillCalculateDto.builder()
                .commnunicationSkill(softSkillDto.getCommnunicationSkill()*major.getCommunicationWeight()*weight)
                .collaborationSkill(softSkillDto.getCollaborationSkill()*major.getCollaborationWeight()*weight)
                .problemSolvingSkill(softSkillDto.getProblemSolvingSkill()*major.getProblemSolvingWeight()*weight)
                .networkingSkill(softSkillDto.getNetworkingSkill()*major.getNetworkingWeight()*weight)
                .totalValue((softSkillDto.getCommnunicationSkill()*major.getCommunicationWeight() + softSkillDto.getCollaborationSkill()*major.getCollaborationWeight() + softSkillDto.getProblemSolvingSkill()* major.getProblemSolvingWeight() + softSkillDto.getNetworkingSkill()*major.getNetworkingWeight())*weight)
                .build();
    }
}
