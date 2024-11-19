package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Role {
    @Id
    String name;
    String description;

    @ManyToMany
    Set<Permission> permissions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    Set<Account> accounts;
}
