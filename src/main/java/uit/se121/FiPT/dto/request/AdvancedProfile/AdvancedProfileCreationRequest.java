package uit.se121.FiPT.dto.request.AdvancedProfile;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvancedProfileCreationRequest {
    String user;
    String yearCollege;
    String major;
    String address;
    List<String> workingTime;
    int commnunicationSkill;
    int collaborationSkill;
    int problemSolvingSkill;
    int networkingSkill;
    int skillScore1;
    int skillScore2;
    int skillScore3;
    int wage;
    int suitableTime;
}
