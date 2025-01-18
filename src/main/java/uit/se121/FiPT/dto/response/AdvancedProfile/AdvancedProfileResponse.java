package uit.se121.FiPT.dto.response.AdvancedProfile;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvancedProfileResponse {
    String user;
    String yearCollege;
    String major;
    String address;
    List<String> workingTime;
}
