package uit.se121.FiPT.dto.calculateParameter.N_Score;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.common.Workship;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonalNeedDto {
    int wage;
    List<Workship> availabilities;
    int time;
}
