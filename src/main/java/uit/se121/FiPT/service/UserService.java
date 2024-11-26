package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.UserRequest.UserCreationRequest;
import uit.se121.FiPT.dto.request.UserRequest.UserProfileUpdateRequest;
import uit.se121.FiPT.dto.response.AccountResponse.UserProfileResponse;
import uit.se121.FiPT.dto.response.AccountResponse.UserResponse;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.entity.Account;
import uit.se121.FiPT.entity.User;
import uit.se121.FiPT.exception.AppException;
import uit.se121.FiPT.exception.ErrorCode;
import uit.se121.FiPT.mapper.AccountMapper;
import uit.se121.FiPT.mapper.UserMapper;
import uit.se121.FiPT.repository.AccountRepository;
import uit.se121.FiPT.repository.RoleRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    RoleRepository roleRepository;
    UserRepository userRepository;
    AccountRepository accountRepository;

    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request) {
        if(accountRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.ACCOUNT_EXISTED);
        }
        Account account = Account.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .creationDate(LocalDate.now())
                .email(request.getEmail())
                .isActive(true)
                .role(roleRepository.findByName(request.getRole()).get())
                .build();

        User user = new User();
        user.setAccount(account);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserProfileResponse getMyProfile(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByAccount_Username(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserProfileResponse(user);
    }

    public UserProfileResponse updateUserProfile(String userId, UserProfileUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUserProfile(user, request);

        return userMapper.toUserProfileResponse(userRepository.save(user));
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

//    @PostAuthorize("returnObject.account.username == authentication.name")
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
}
