package uit.se121.FiPT.dto.response.AccountResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    String username;
    String password;
    String email;
    Boolean isActive;
    String role;
}
