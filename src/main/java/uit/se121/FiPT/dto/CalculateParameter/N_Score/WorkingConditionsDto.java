package uit.se121.FiPT.dto.CalculateParameter;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.common.Workship;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkingConditionsDto {
    int wage;
    List<Workship> work;
}
