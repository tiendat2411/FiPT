package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.request.AccountRequest.AccountCreationRequest;
import uit.se121.FiPT.dto.request.UserRequest.UserCreationRequest;
import uit.se121.FiPT.dto.request.UserRequest.UserProfileUpdateRequest;
import uit.se121.FiPT.dto.response.AccountResponse.AccountResponse;
import uit.se121.FiPT.dto.response.AccountResponse.UserResponse;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.AccountResponse.UserProfileResponse;
import uit.se121.FiPT.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping("/myInfo")
    ApiResponse<UserProfileResponse> getMyInfo() {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userService.getMyProfile())
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserProfileResponse> updateUser(@PathVariable String userId, @RequestBody UserProfileUpdateRequest request) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userService.updateUserProfile(userId, request))
                .build();
    }

    @PostMapping("/register")
    public ApiResponse<UserResponse> registerAccount(@RequestBody @Validated UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }
}
