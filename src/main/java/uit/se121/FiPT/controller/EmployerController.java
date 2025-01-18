package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.Employer_Response.EmployerResponse;
import uit.se121.FiPT.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/employers")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployerController {
    EmployerService employerService;

    @GetMapping
    ApiResponse<List<EmployerResponse>> getAllEmployers() {
        return ApiResponse.<List<EmployerResponse>>builder()
                .result(employerService.getAllEmployers())
                .build();
    }
}
