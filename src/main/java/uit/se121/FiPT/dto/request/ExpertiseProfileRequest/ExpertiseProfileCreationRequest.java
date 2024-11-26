package uit.se121.FiPT.dto.request.ExpertiseProfileRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpertiseProfileCreationRequest {
    String user;
    String yearCollege;
    String major;
    String address;
    int pointCommunicate;
    int pointExperience;
    int pointEconomy;
    int pointExpertise;
}
