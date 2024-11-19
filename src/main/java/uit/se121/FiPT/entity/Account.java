package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    String id;

    @Column
    String username;

    @Column
    String password;

    @Column
    String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    Role role;

    @Column
    Boolean isActive;

    @Column
    LocalDate creationDate;
}
