package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.UserRequest.IsLoginRequest;
import uit.se121.FiPT.dto.request.UserRequest.UserCreationRequest;
import uit.se121.FiPT.dto.request.UserRequest.UserProfileUpdateRequest;
import uit.se121.FiPT.dto.response.AccountResponse.*;
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
    AccountMapper accountMapper;
    PasswordEncoder passwordEncoder;

    public IsLoginResponse isLogin(IsLoginRequest isLoginRequest) {
        User user = userRepository.findByAccount_Email(isLoginRequest.getEmail());

        if ( user != null ) {
            return IsLoginResponse.builder()
                    .success(true)
                    .isLogin(true)
                    .build();
        } else {
            return IsLoginResponse.builder()
                    .success(true)
                    .isLogin(false)
                    .build();
        }
    }

    public AccountResponse createUser(UserCreationRequest request) {
        if (accountRepository.existsByUsername(request.getUsername())) {
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
        userRepository.saveAndFlush(user);
        return accountMapper.toAccountResponse(account);
    }

    public MyProfileResponse getMyProfile() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        User user = userRepository.findByAccount_Username(name).get();
        MyProfileResponse response =  userMapper.toMyProfileResponse(user);
        response.setCreationDate(user.getAccount().getCreationDate().toString());
        return response;
    }

    public UserProfileResponse updateUserProfile(String userId, UserProfileUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        System.out.println(request.getResume());
        userMapper.updateUserProfile(user, request);

        return userMapper.toUserProfileResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    //    @PostAuthorize("returnObject.account.username == authentication.name")
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
}
