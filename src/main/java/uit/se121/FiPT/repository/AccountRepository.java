package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account, String> {
    public Optional<Account> findByUsername(String username);
    public Boolean existsByUsername(String username);
}
