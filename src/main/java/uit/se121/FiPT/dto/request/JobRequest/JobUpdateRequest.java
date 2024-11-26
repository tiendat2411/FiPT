package uit.se121.FiPT.dto.request.JobRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobUpdateRequest {
    String name;
    String description;
    double wage;
    String address;
    String contactInfo;
    String requirements;
    List<String> imageUrl;
    String status;
}
