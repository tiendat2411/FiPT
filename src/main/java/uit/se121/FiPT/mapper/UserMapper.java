package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uit.se121.FiPT.dto.request.AccountRequest.AccountCreationRequest;
import uit.se121.FiPT.dto.request.UserRequest.UserProfileUpdateRequest;
import uit.se121.FiPT.dto.response.AccountResponse.MyProfileResponse;
import uit.se121.FiPT.dto.response.AccountResponse.UserProfileResponse;
import uit.se121.FiPT.dto.response.AccountResponse.UserResponse;
import uit.se121.FiPT.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(AccountCreationRequest request);

    UserResponse toUserResponse(User user);

    UserProfileResponse toUserProfileResponse(User user);

    @Mapping(target = "creationDate", ignore = true)
    @Mapping(source = "account.email", target = "email")
    MyProfileResponse toMyProfileResponse(User user);

    //    @Mapping(target = "roles", ignore = true)
    @Mapping(source = "resume", target = "resume")
    void updateUserProfile(@MappingTarget User user, UserProfileUpdateRequest request);
}
