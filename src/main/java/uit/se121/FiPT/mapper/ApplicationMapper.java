package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import uit.se121.FiPT.dto.request.ApplicationRequest.ApplyJobRequest;
import uit.se121.FiPT.dto.response.ApplicationResponse.ApplicationResponse;
import uit.se121.FiPT.entity.Application;
import uit.se121.FiPT.repository.EmployerRepository;
import uit.se121.FiPT.repository.JobJpaRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public class ApplicationMapper {
    UserRepository userRepository;
    JobJpaRepository jobRepository;
    EmployerRepository employerRepository;

    public Application toApplication(ApplyJobRequest request){

        return Application.builder()
                .user(userRepository.findById(request.getUser()).get())
                .job(jobRepository.findById(request.getJob()).get())
                .employer(jobRepository.findById(request.getJob()).get().getEmployer())
                .date(LocalDateTime.now())
                .cvUrls(request.getCvUrls())
                .build();
    }


    public ApplicationResponse toApplicationResponse(Application application){
        return ApplicationResponse.builder()
                .user(application.getUser().getId()+" "+application.getUser().getFirstName())
                .job(application.getJob().getName())
                .employer(application.getEmployer().getName())
                .status(application.getStatus())
                .date(application.getDate().toString())
                .cvUrls(application.getCvUrls())
                .build();
    }
}
