package uit.se121.FiPT.dto.request.UserRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileUpdateRequest {
    String firstName;
    String lastName;
    Integer age;
    Boolean gender;
    String avatar;
    String resume;
    String phoneNumber;
    String description;

}
