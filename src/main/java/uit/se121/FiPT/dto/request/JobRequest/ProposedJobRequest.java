package uit.se121.FiPT.dto.request.JobRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillCalculateDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProposedJobRequest {
    String name;
    String description;
    String jobCategory;
    int wage;
    String address;
    String employerName;
    String detailUrls;
    String jobValue;
    List<String> workships;

    SoftSkillCalculateDto sScore;
    ExpertiseSkillCalculateDto eScore;
    PersonalNeedCalculateDto nScore;
    double totalSocre;
}
