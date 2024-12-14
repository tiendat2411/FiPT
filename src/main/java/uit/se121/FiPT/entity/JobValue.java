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
@Table(name = "job_value")
public class JobValue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "job_value_id")
    String id;

    @OneToOne
    @JoinColumn(name = "job_id")
    Job job;

    @Column(name = "communication_skill")
    int commnunicationSkill;

    @Column(name = "collaboration_skill")
    int collaborationSkill;

    @Column(name = "problem_solving_skill")
    int problemSolvingSkill;

    @Column(name = "networking_skill")
    int networkingSkill;

    @Column(name = "ex_skill_1")
    int expertiseSkill1;

    @Column(name = "ex_skill_2")
    int expertiseSkill2;

    @Column(name = "ex_skill_3")
    int expertiseSkill3;

    @Column(name = "wage_score")
    int wageScore;

    @Column(name = "time_score")
    int timeScore;

    @Column(name = "main_ex_skill_1")
    String mainExpertiseSkill1;

    @Column(name = "main_ex_skill_2")
    String mainExpertiseSkill2;

    @Column(name = "main_ex_skill_2")
    String mainExpertiseSkill3;
}
