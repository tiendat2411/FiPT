package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, String> {

}
