package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uit.se121.FiPT.common.ExpertiseSkill;
import uit.se121.FiPT.common.SoftSkill;
import uit.se121.FiPT.common.Workship;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "special_info")
public class AdvanceProfile {
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

    @Embedded
    SoftSkill softSkill;

    @Embedded
    ExpertiseSkill  expertiseSkill;

    @ElementCollection
    List<Workship> workingTime;

    @Column(name = "point_communicate")
    int pointCommunicate;

    @Column(name = "point_experience")
    int pointExperience;

    @Column(name = "point_economy")
    int pointEconomy;

    @Column(name = "point_expertise")
    int pointExpertise;
}
