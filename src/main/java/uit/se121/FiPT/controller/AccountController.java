package uit.se121.FiPT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.request.AccountRequest.AccountCreationRequest;
import uit.se121.FiPT.dto.response.AccountResponse.AccountResponse;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.mapper.AccountMapper;
import uit.se121.FiPT.service.AccountService;
import uit.se121.FiPT.service.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<AccountResponse> registerAccount(@RequestBody @Validated AccountCreationRequest request) {
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.createAccount(request))
                .build();
    }
}
