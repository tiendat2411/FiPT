package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.ApplicationRequest.ApplyJobRequest;
import uit.se121.FiPT.dto.response.ApplicationResponse.ApplicationResponse;
import uit.se121.FiPT.entity.Application;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.mapper.ApplicationMapper;
import uit.se121.FiPT.repository.ApplicationRepository;
import uit.se121.FiPT.repository.EmployerRepository;
import uit.se121.FiPT.repository.JobJpaRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicaionService {
    ApplicationRepository applicationRepository;
    UserRepository userRepository;
    EmployerRepository employerRepository;
    JobJpaRepository jobRepository;

    ApplicationMapper applicationMapper;

    public ApplicationResponse applyJob(ApplyJobRequest request) {
//        if (applicationRepository.findById(request.getJob()).get().getStatus().equals("Approved")) {
//            throw new AppException(ErrorCode.JOB_APPROVED);
//        }

        Application application = Application.builder()
                .user(userRepository.findById(request.getUser()).get())
                .job(jobRepository.findById(request.getJob()).get())
                .employer(jobRepository.findById(request.getJob()).get().getEmployer())
                .date(LocalDateTime.now())
                .cvUrls(request.getCvUrls())
                .build();
        application.setStatus("Applied");
        return applicationMapper.toApplicationResponse(applicationRepository.save(application));
    }

    public ApplicationResponse approveApplication(String applicationId) {
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("Approved");

        Job job = application.getJob();
        job.setStatus("Approved");
        job.setUser(application.getUser());

        return applicationMapper.toApplicationResponse(applicationRepository.save(application));
    }

    public ApplicationResponse rejectApplication(String applicationId) {
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("Rejected");

        return applicationMapper.toApplicationResponse(applicationRepository.save(application));
    }

    public ApplicationResponse underReviewApplication(String applicationId) {
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("Under Review");

        return applicationMapper.toApplicationResponse(applicationRepository.save(application));
    }

    public List<ApplicationResponse> getAllApplicationsByEmployer(String employerId) {
        return applicationRepository.findByEmployer_Id(employerId).stream()
                .map(applicationMapper::toApplicationResponse).toList();
    }

    public List<ApplicationResponse> getAllApplicationsByUser(String userId) {
        return applicationRepository.findByUser_Id(userId).stream()
                .map(applicationMapper::toApplicationResponse).toList();
    }

    public List<ApplicationResponse> getAllApplications() {
        return applicationRepository.findAll().stream()
                .map(applicationMapper::toApplicationResponse).toList();
    }
}
