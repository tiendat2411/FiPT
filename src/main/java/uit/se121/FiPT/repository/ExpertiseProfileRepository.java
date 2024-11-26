package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.ExpertiseProfile;

@Repository
public interface ExpertiseProfileRepository extends JpaRepository<ExpertiseProfile, String> {
     ExpertiseProfile findByUser_Id(String id);
}
