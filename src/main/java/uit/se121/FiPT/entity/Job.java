package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;
import uit.se121.FiPT.common.Workship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "job")
@Document(indexName = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "job_id")
    String id;

    @OneToOne(mappedBy = "job", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    JobValue jobValue;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    @Column
    String name;

    @Column
    String description;

    @Column(name = "recruited_date")
    LocalDate recruitedDate;

    @Column(name = "accepted_date")
    LocalDate acceptedDate;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "job_category", nullable = false)
    Category jobCategory;

    @Column
    int wage;

    @Column
    String address;

    @Column(name = "contact_info")
    String contactInfo;

    @Column
    String requirements;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "employer_id", nullable = false)
    Employer employer;

    @ElementCollection
    List<Workship> schedule;

    @ElementCollection
    @CollectionTable(name = "job_images", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "image_url")
    List<String> imageUrls = new ArrayList<>();

    @Column
    String status;
}
