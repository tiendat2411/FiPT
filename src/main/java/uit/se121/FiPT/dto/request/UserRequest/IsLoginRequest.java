package uit.se121.FiPT.dto.request.UserRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IsLoginRequest {
    String email;
    String password;
}
