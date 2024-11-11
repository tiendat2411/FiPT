package uit.se121.FiPT.dto.request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.entity.Workship;

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
}
