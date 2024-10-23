package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "route_job")
public class RouteJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int duration;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST
    })
    @JoinTable(
            name = "jobprocess_job", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Job> jobProcess;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST
    })
    @JoinTable(
            name = "proposedroute_job",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> proposedRoute;

    @ElementCollection
    private List<Integer> pointValue;
}
