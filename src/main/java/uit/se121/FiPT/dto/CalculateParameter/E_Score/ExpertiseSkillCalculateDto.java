package uit.se121.FiPT.dto.CalculateParameter.E_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpertiseSkillCalculateDto {
    int expertiseSkill1;

    int expertiseSkill2;

    int expertiseSkill3;

    int totalValue;
}
