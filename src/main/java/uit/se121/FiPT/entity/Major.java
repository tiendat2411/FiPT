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
@Table(name = "major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "major_id")
    String id;

    @Column(name = "major_name")
    String name;

    @Column(name = "communication_weight")
    int communicationWeight;

    @Column(name = "collaboration_weight")
    int collaborationWeight;

    @Column(name = "problemSolving_weight")
    int problemSolvingWeight;

    @Column(name = "networking_weight")
    int networkingWeight;

    @Column(name = "wage_weight")
    int wage;

    @Column(name ="time_weight")
    int time;

    @Column(name = "ex_skill_1")
    String expertiseSkillName1;

    @Column(name = "ex_skill_2")
    String expertiseSkillName2;

    @Column(name = "ex_skill_3")
    String expertiseSkillName3;
}
