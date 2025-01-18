package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uit.se121.FiPT.dto.request.JobRequest.JobCreationRequest;
import uit.se121.FiPT.dto.request.JobRequest.JobUpdateRequest;
import uit.se121.FiPT.dto.response.Job_Response.JobResponse;
import uit.se121.FiPT.entity.Job;


@Mapper(componentModel = "spring")
public interface JobMapper {
    @Mapping(target = "employer", ignore = true)
    @Mapping(target = "jobCategory", ignore = true)
    @Mapping(target = "imageUrls", ignore = true)
    Job toJob(JobCreationRequest request);

    @Mapping(source = "employer.name", target = "employerName")
    @Mapping(source = "jobCategory.name", target = "jobCategory")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "imageUrls", target = "imageUrls")
    JobResponse toJobResponse(Job job);

    Job updateJob(@MappingTarget Job job, JobUpdateRequest request);
}

