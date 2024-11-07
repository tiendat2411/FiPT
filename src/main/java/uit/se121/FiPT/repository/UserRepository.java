package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    public Page<User> findByIdContaining(@RequestParam("id") String id, Pageable pageable);

    public boolean existsByEmail(String email);

    public boolean existsByFirstName(String firstName);

    public User findByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    public Optional<User> findById(String id);

    public Optional<User> deleteById(String id);
}
