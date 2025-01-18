package uit.se121.FiPT.dto.calculateParameter.N_Score;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonalNeedCalculateDto {
    double wageScore;
    double timeScore;
    double totalValue;
}
