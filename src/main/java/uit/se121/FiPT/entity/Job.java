package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int id;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "recruited_date")
    private Date recruitedDate;

    @Column(name = "accepted_date")
    private Date acceptedDate;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "job_category", nullable = false)
    private Category jobCategory;

    @Column
    private double wage;

    @Column
    private String address;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column
    private String requirements;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @ElementCollection
    private List<Workship> schedule;
}
