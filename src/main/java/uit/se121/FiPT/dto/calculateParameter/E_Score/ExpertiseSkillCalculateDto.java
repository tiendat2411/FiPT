package uit.se121.FiPT.dto.calculateParameter.E_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpertiseSkillCalculateDto {
    double expertiseSkill1;

    double expertiseSkill2;

    double expertiseSkill3;

    double totalValue;
}
