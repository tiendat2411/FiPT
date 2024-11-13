package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
