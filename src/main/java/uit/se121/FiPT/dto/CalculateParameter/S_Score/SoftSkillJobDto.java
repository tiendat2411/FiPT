package uit.se121.FiPT.dto.CalculateParameter.S_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoftSkillJobDto {
    int commnunicationSkill;

    int collaborationSkill;

    int problemSolvingSkill;

    int networkingSkill;
}
