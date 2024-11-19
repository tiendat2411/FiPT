package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.AccountRequest.AccountCreationRequest;
import uit.se121.FiPT.dto.response.AccountResponse.AccountResponse;
import uit.se121.FiPT.entity.Account;
import uit.se121.FiPT.exception.AppException;
import uit.se121.FiPT.exception.ErrorCode;
import uit.se121.FiPT.mapper.AccountMapper;
import uit.se121.FiPT.repository.AccountRepository;
import uit.se121.FiPT.repository.RoleRepository;
import java.time.LocalDate;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AccountService {
    AccountRepository accountRepository;
    RoleRepository roleRepository;

    AccountMapper accountMapper;
    PasswordEncoder passwordEncoder;

    public AccountResponse createAccount(AccountCreationRequest request){
        if(accountRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.ACCOUNT_EXISTED);
        }
        Account account = accountMapper.toAccount(request);

        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setCreationDate(LocalDate.now());
        account.setRole(roleRepository.findByName(request.getRole()).get());

        return accountMapper.toAccountResponse(accountRepository.save(account));
    }
}
