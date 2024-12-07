package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uit.se121.FiPT.dto.request.ApplicationRequest.ApplyJobRequest;
import uit.se121.FiPT.dto.response.ApplicationResponse.ApplicationResponse;
import uit.se121.FiPT.entity.Application;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "employer", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "date", ignore = true)
    Application toApplication(ApplyJobRequest request);

    ApplicationResponse toApplicationResponse(Application account);
}
