package uit.se121.FiPT.dto.CalculateParameter;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoftSkillCalculateDto {
    int commnunicationSkill;

    int collaborationSkill;

    int problemSolvingSkill;

    int networkingSkill;

    int totalValue;
}