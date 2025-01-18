package uit.se121.FiPT.service;

import jakarta.persistence.criteria.Predicate;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.JobRequest.JobCreationRequest;
import uit.se121.FiPT.dto.request.JobRequest.JobUpdateRequest;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.Job_Response.JobResponse;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.exception.AppException;
import uit.se121.FiPT.exception.ErrorCode;
import uit.se121.FiPT.mapper.JobMapper;
import uit.se121.FiPT.repository.CategoryRepository;
import uit.se121.FiPT.repository.EmployerRepository;
import uit.se121.FiPT.repository.JobJpaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class JobService {
    JobJpaRepository jobRepository;
    EmployerRepository employerRepository;
    CategoryRepository categoryRepository;

    JobMapper jobMapper;

    public List<JobResponse> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> jobResponses = new ArrayList<>();
        for (Job job : jobs) {
            JobResponse jobResponse = jobMapper.toJobResponse(job);
            jobResponses.add(jobResponse);
        }
        return jobResponses;
    }

//    public Page<JobResponse> getJobs(Pageable pageable) {
//        Page<Job> jobs = jobRepository.findAll(pageable);
//        return jobs.map(jobMapper::toJobResponse);
//    }

    public Page<JobResponse> getJobs(int page, int size, String search, String category, Integer wage, String employer) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("recruitedDate").descending());

        return jobRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (search != null && !search.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + search + "%"));
            }
            if (category != null && !category.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("jobCategory").get("name"), category));
            }
            if (wage != null && wage > 0) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("wage"), wage));
            }
            if (employer != null && !employer.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("employer").get("name"), employer));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable).map(job -> jobMapper.toJobResponse(job));
    }

    public JobResponse createJob(JobCreationRequest request) {
        Job job = jobMapper.toJob(request);
        Employer employer = employerRepository.findById(request.getEmployerId()).get();
        Category category = categoryRepository.findById(request.getCategoryId()).get();
        job.setEmployer(employer);
        job.setJobCategory(category);
        job.setRecruitedDate(LocalDate.now());
        ArrayList<String> images = new ArrayList<>();
        images.add(request.getImageUrl());
        job.setImageUrls(images);
        jobRepository.save(job);
        return jobMapper.toJobResponse(job);
    }

    public ApiResponse<String> deleteJob(String id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.JOB_NOT_FOUND));

        if (job.getUser() != null) {
            throw new AppException(ErrorCode.JOB_ACCEPTED);
        }

        jobRepository.deleteById(id);
        return ApiResponse.<String>builder()
                .code(2000)
                .message("Delete job successfully")
                .result(null)
                .build();
    }

    public JobResponse updateJob(JobUpdateRequest request, String jobId) {
        Job jobUpdated = jobRepository.findById(jobId).get();

        jobMapper.updateJob(jobUpdated, request);

        jobRepository.save(jobUpdated);
        return jobMapper.toJobResponse(jobUpdated);
    }

    public JobResponse getJob(String jobId) {
        Job job = jobRepository.findById(jobId).get();

        return jobMapper.toJobResponse(job);
    }

}
