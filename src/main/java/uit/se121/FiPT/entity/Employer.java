package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employer_id")
    String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    Account account;

    @Column
    String name;

    @Column
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column
    String avatar;

    @Column
    String description;

    @Column(name = "contact_info")
    String contactInfo;

    @Column(name = "job_list")
    @OneToMany(mappedBy = "employer", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    List<Job> jobList;


    @Column(name = "application_list")
    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH
    })
    List<Application> applicationList;
}
