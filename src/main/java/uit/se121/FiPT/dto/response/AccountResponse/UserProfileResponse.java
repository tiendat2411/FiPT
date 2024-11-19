package uit.se121.FiPT.dto.response.AccountResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileResponse {
    String id;
    String firstName;
    String lastName;
    Integer age;
    Boolean gender;
    String avatar;
    String phoneNumber;
}