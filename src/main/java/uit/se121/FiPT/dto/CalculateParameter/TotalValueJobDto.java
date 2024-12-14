package uit.se121.FiPT.dto.CalculateParameter;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.dto.CalculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.S_Score.SoftSkillCalculateDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TotalValueJobDto {
    SoftSkillCalculateDto sScore;
    ExpertiseSkillCalculateDto eScore;
    PersonalNeedCalculateDto nScore;
    int totalSocre;
}
