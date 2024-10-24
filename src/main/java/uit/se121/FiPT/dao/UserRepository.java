package uit.se121.FiPT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
