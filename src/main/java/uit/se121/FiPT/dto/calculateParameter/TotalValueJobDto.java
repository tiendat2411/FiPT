package uit.se121.FiPT.dto.calculateParameter;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillCalculateDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TotalValueJobDto {
    SoftSkillCalculateDto sScore;
    ExpertiseSkillCalculateDto eScore;
    PersonalNeedCalculateDto nScore;
    double totalSocre;
}
