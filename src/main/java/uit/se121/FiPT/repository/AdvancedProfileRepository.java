package uit.se121.FiPT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.AdvancedProfile;

@Repository
public interface AdvancedProfileRepository extends JpaRepository<AdvancedProfile, String> {
     AdvancedProfile findByUser_Id(String id);
}
