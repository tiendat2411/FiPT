package uit.se121.FiPT.common;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import uit.se121.FiPT.entity.Job;

import java.util.ArrayList;
import java.util.List;

public class JobSpecification {
    public static Specification<Job> filterJobs(String search, String category, Integer salary, String company) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Tìm kiếm theo tiêu đề hoặc tên công việc
            if (search != null && !search.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + search + "%"));
            }

            // Lọc theo danh mục
            if (category != null && !category.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }

            // Lọc theo mức lương tối thiểu
            if (salary != null && salary > 0) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), salary));
            }

            // Lọc theo công ty
            if (company != null && !company.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("companyName"), company));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
