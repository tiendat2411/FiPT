package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import uit.se121.FiPT.dto.response.Employer_Response.EmployerResponse;
import uit.se121.FiPT.entity.Employer;

@Mapper(componentModel = "spring")
public interface EmployerMapper {
    EmployerResponse toEmployerResponse(Employer employer);
}
