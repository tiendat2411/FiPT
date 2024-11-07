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
public class SpecialInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "specialinfo_id")
    String id;

    @OneToOne  // Nếu mỗi Wishlist chỉ có một User
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "year_college")
    String yearCollege;

    @Column
    String major;

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
