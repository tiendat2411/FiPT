package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uit.se121.FiPT.dto.request.ApplicationRequest.ApplyJobRequest;
import uit.se121.FiPT.dto.response.ApplicationResponse.ApplicationResponse;
import uit.se121.FiPT.dto.response.RouteJobResponse.RouteJobResponse;
import uit.se121.FiPT.entity.Application;
import uit.se121.FiPT.repository.EmployerRepository;
import uit.se121.FiPT.repository.JobRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public class ApplicationMapper {
    UserRepository userRepository;
    JobRepository jobRepository;
    EmployerRepository employerRepository;

    public Application toApplication(ApplyJobRequest request){
        return Application.builder()
                .user(userRepository.findById(request.getUser()).get())
                .job(jobRepository.findById(request.getJob()).get())
                .employer(employerRepository.findById(request.getEmployer()).get())
                .date(LocalDateTime.parse(request.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .status(request.getStatus())
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
