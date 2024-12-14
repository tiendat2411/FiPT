package uit.se121.FiPT.common;

import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoftSkill {
    int commnunicationSkill;
    int collaborationSkill;
    int problemSolvingSkill;
    int networkingSkill;
}
