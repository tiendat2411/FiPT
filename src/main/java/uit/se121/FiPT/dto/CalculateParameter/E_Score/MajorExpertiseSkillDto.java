package uit.se121.FiPT.dto.CalculateParameter.E_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MajorExpertiseSkillDto {
    String exSkill1;
    String exSkill2;
    String exSkill3;
}
