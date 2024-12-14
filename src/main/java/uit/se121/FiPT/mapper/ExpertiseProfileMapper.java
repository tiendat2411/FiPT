package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uit.se121.FiPT.dto.request.ExpertiseProfileRequest.ExpertiseProfileCreationRequest;
import uit.se121.FiPT.dto.request.ExpertiseProfileRequest.UpdateExpertiseProfileRequest;
import uit.se121.FiPT.dto.response.ExpertiseProfileRespone.ExpertiseProfileResponse;
import uit.se121.FiPT.entity.AdvanceProfile;

@Mapper(componentModel = "spring")
public interface ExpertiseProfileMapper {
    @Mapping(target = "user", ignore = true)
    AdvanceProfile toExpertiseProfile(ExpertiseProfileCreationRequest request);

    @Mapping(source = "user.id", target = "user")
    ExpertiseProfileResponse toExpertiseProfileResponse(AdvanceProfile expertiseProfile);

    @Mapping(target = "user", ignore = true)
    AdvanceProfile updateExpertiseProfile(@MappingTarget AdvanceProfile expertiseProfile, UpdateExpertiseProfileRequest request);
}
