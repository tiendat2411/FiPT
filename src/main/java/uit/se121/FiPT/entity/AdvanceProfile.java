package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "special_info")
public class ExpertiseProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "specialinfo_id")
    String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "year_college")
    String yearCollege;

    @Column
    @ManyToOne
    Major major;

    @Column
    String address;

    @Column(name = "point_communicate")
    int pointCommunicate;

    @Column(name = "point_experience")
    int pointExperience;

    @Column(name = "point_economy")
    int pointEconomy;

    @Column(name = "point_expertise")
    int pointExpertise;
}
