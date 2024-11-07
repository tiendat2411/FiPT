package uit.se121.FiPT.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uit.se121.FiPT.dto.request.UserCreationRequest;
import uit.se121.FiPT.dto.request.UserUpdateRequest;
import uit.se121.FiPT.dto.response.UserResponse;
import uit.se121.FiPT.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
