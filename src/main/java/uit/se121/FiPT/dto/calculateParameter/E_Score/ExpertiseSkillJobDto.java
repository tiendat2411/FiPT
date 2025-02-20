package uit.se121.FiPT.dto.calculateParameter.E_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpertiseSkillJobDto {
    String skillName1;

    String skillName2;

    String skillName3;

    int expertiseSkill1;

    int expertiseSkill2;

    int expertiseSkill3;
}
