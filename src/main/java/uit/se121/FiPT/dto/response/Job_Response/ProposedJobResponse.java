package uit.se121.FiPT.dto.response.Job_Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillCalculateDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProposedJobResponse {
    String name;
    String description;
    String jobCategory;
    double wage;
    String address;
    String employerName;
    String detailUrls;

    SoftSkillCalculateDto sScore;
    ExpertiseSkillCalculateDto eScore;
    PersonalNeedCalculateDto nScore;
    double totalSocre;
}
