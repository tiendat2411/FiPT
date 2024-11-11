package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.JobCreationRequest;
import uit.se121.FiPT.dto.response.JobResponse;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.mapper.JobMapper;
import uit.se121.FiPT.mapper.UserMapper;
import uit.se121.FiPT.repository.CategoryRepository;
import uit.se121.FiPT.repository.EmployerRepository;
import uit.se121.FiPT.repository.JobRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class JobService {
    JobMapper jobMapper;
    JobRepository jobRepository;
    EmployerRepository employerRepository;
    CategoryRepository categoryRepository;

    public JobResponse createJob(JobCreationRequest request) {
        Employer employer = employerRepository.findById(request.getEmployerId()).get();
        Category category = categoryRepository.findById(request.getCategoryId()).get();
        Job job = Job.builder()
                .name(request.getName())
                .description(request.getDescription())
                .wage(request.getWage())
                .jobCategory(category)
                .address(request.getAddress())
                .contactInfo(request.getContactInfo())
                .requirements(request.getRequirements())
                .employer(employer)
                .recruitedDate(request.getRecruitedDate())
                .build();
        return jobMapper.toJobResponse(jobRepository.save(job));
    }
}
