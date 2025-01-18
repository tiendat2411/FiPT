package uit.se121.FiPT.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uit.se121.FiPT.entity.Job;

@Repository
public interface JobJpaRepository extends JpaRepository<Job, String>, JpaSpecificationExecutor<Job> {
    //    Page<Job> findAll(Pageable pageable);
    public Page<Job> findAll(Specification<Job> spec, Pageable pageable);
}
