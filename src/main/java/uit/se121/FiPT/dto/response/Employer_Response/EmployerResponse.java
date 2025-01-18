package uit.se121.FiPT.dto.response.Employer_Response;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.entity.Application;
import uit.se121.FiPT.entity.Job;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployerResponse {
    String id;
    String name;
    String email;
    String phoneNumber;
    String avatar;
    String description;
    String contactInfo;
}
