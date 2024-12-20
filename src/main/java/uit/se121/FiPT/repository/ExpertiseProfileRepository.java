package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.AdvanceProfile;

@Repository
public interface ExpertiseProfileRepository extends JpaRepository<AdvanceProfile, String> {
     AdvanceProfile findByUser_Id(String id);
}
