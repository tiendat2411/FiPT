package uit.se121.FiPT.dto.response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.entity.User;
import uit.se121.FiPT.entity.Workship;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
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
}
