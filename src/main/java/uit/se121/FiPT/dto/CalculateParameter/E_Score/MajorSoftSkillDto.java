package uit.se121.FiPT.dto.CalculateParameter.E_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MajorSoftSkillDto {
    int communicationWeight;

    int collaborationWeight;

    int problemSolvingWeight;

    int networkingWeight;
}
