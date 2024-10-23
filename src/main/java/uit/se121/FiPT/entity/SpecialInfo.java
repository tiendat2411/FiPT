package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "special_info")
public class SpecialInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialinfo_id")
    private int id;

    @OneToOne  // Nếu mỗi Wishlist chỉ có một User
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "year_college")
    private String yearCollege;

    @Column
    private String major;

    @Column
    private String address;

    @Column(name = "point_communicate")
    private int pointCommunicate;

    @Column(name = "point_experience")
    private int pointExperience;

    @Column(name = "point_economy")
    private int pointEconomy;

    @Column(name = "point_expertise")
    private int pointExpertise;
}
