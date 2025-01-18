package uit.se121.FiPT.dto.request.AdvancedProfile;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvancedProfileRequest {
    String user;
    String yearCollege;
    String major;
    String address;
    List<String> workingTime;
}
