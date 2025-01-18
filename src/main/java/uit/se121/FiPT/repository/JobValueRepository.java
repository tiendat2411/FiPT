package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.JobValue;

@Repository
public interface JobValueRepository extends JpaRepository<JobValue, String> {
}
