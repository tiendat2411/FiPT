package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String description;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "job_list")
    @OneToMany(mappedBy = "employer", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Job>jobList;


    @Column(name = "application_list")
    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH , CascadeType.DETACH
    })
    private List<Application> applicationList;
}
