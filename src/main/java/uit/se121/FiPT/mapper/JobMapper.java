package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import uit.se121.FiPT.dto.request.JobCreationRequest;
import uit.se121.FiPT.dto.response.JobResponse;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.repository.EmployerRepository;

@Mapper(componentModel = "spring")
public abstract class JobMapper {

    @Autowired
    private EmployerRepository employerRepository;

    // Không sử dụng @Mapping cho employerId nữa.
//    @Mapping(target = "employer", ignore = true)  // Chúng ta sẽ thiết lập employer sau
    public abstract Job toJob(JobCreationRequest request);

    public abstract JobResponse toJobResponse(Job job);

    // @AfterMapping sẽ gán đối tượng Employer vào Job sau khi ánh xạ
//    @AfterMapping
//    protected void setEmployer(JobCreationRequest request, @MappingTarget Job job) {
//        Employer employer = employerRepository.findById(request.getEmployerId())
//                .orElseThrow(() -> new RuntimeException("Employer not found"));
//        job.setEmployer(employer);
//    }
}
