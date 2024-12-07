package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.time.Period;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "route_job")
public class RouteJob {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "route_id")
    String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column
    Period duration;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST
    })
    @JoinTable(
            name = "jobprocess_job",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    List<Job> jobProcess;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST
    })
    @JoinTable(
            name = "proposedroute_job",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> proposedRoute;

    @ElementCollection
    List<Integer> pointValue;
}
