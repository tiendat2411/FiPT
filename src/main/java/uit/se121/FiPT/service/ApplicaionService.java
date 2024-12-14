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
import uit.se121.FiPT.exception.AppException;
import uit.se121.FiPT.exception.ErrorCode;
import uit.se121.FiPT.mapper.ApplicationMapper;
import uit.se121.FiPT.repository.ApplicationRepository;
import uit.se121.FiPT.repository.EmployerRepository;
import uit.se121.FiPT.repository.JobRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicaionService {
    ApplicationRepository applicationRepository;
    UserRepository userRepository;
    EmployerRepository employerRepository;
    JobRepository jobRepository;

    ApplicationMapper applicationMapper;

    public ApplicationResponse applyJob(ApplyJobRequest request) {
        if (applicationRepository.findById(request.getJob()).get().getStatus().equals("Approved")) {
            throw new AppException(ErrorCode.JOB_APPROVED);
        }

        Application application = applicationMapper.toApplication(request);
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
}
