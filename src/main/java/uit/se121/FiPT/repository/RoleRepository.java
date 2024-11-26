package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.Role;


import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    public Optional<Role> findByName(String name);
}
