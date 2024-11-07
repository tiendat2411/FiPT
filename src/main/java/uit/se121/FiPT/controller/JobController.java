package uit.se121.FiPT.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.se121.FiPT.dto.request.ApiResponse;
import uit.se121.FiPT.dto.request.JobCreationRequest;
import uit.se121.FiPT.dto.response.JobResponse;
import uit.se121.FiPT.service.JobService;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobController {
    JobService jobService;

    @PostMapping
    ApiResponse<JobResponse> createJob(@RequestBody @Valid JobCreationRequest request) {
        return ApiResponse.<JobResponse>builder()
                .result(jobService.createJob(request))
                .build();
    }
}
