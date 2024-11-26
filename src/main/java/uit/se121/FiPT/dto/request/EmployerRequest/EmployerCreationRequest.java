package uit.se121.FiPT.dto.request.EmployerRequest;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployerCreationRequest {
    @Size(min = 3,message = "USERNAME_INVALID")
    String name;
    String email;
    String phoneNumber;
    String description;
    String contactInfo;
}
