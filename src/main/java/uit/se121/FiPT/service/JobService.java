package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
import uit.se121.FiPT.repository.JobRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class JobService {
    JobRepository jobRepository;
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

    public JobResponse createJob(JobCreationRequest request) {
        Job job = jobMapper.toJob(request);
        Employer employer = employerRepository.findById(request.getEmployerId()).get();
        Category category = categoryRepository.findById(request.getCategoryId()).get();
        job.setEmployer(employer);
        job.setJobCategory(category);
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

}
