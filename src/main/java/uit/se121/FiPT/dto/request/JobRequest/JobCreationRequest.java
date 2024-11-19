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
public class JobCreationRequest {
    String name;
    String description;
    Date recruitedDate;
    String categoryId;
    double wage;
    String address;
    String contactInfo;
    String requirements;
    String employerId;
    List<String> imageUrl;
}
