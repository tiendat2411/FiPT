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
public class ExpertiseSkill {
    int skillScore1;
    int skillScore2;
    int skillScore3;
}
