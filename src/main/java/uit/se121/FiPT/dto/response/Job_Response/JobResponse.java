package uit.se121.FiPT.dto.response.Job_Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.common.Workship;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
    String id;
    String name;
    String description;
    Date recruitedDate;
    String jobCategory;
    double wage;
    String address;
    String contactInfo;
    String requirements;
    String employerName;
    List<Workship> schedule;
    String status;
    List<String> imageUrls;
}
