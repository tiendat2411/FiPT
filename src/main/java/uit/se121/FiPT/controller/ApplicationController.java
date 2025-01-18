package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.request.ApplicationRequest.ApplyJobRequest;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.ApplicationResponse.ApplicationResponse;
import uit.se121.FiPT.service.ApplicaionService;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationController {
    ApplicaionService applicationService;

    @PostMapping
    ApiResponse<ApplicationResponse> applyJob(@RequestBody ApplyJobRequest request) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.applyJob(request))
                .build();
    }

    @PutMapping("/approve/{applicationId}")
    ApiResponse<ApplicationResponse> approveApplication(@PathVariable String applicationId) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.approveApplication(applicationId))
                .build();
    }

    @PutMapping("/reject/{applicationId}")
    ApiResponse<ApplicationResponse> rejectApplication(@PathVariable String applicationId) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.rejectApplication(applicationId))
                .build();
    }

    @PutMapping("/under-review/{applicationId}")
    ApiResponse<ApplicationResponse> underReviewApplication(@PathVariable String applicationId) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.underReviewApplication(applicationId))
                .build();
    }

    @GetMapping("/{employerId}")
    ApiResponse<List<ApplicationResponse>> getApplicationByEmployer(@PathVariable String employerId) {
        return ApiResponse.<List<ApplicationResponse>>builder()
                .result(applicationService.getAllApplicationsByEmployer(employerId))
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<List<ApplicationResponse>> getApplicationByUser(@PathVariable String userId) {
        return ApiResponse.<List<ApplicationResponse>>builder()
                .result(applicationService.getAllApplicationsByUser(userId))
                .build();
    }

    @GetMapping
    ApiResponse<List<ApplicationResponse>> getAllApplication() {
        return ApiResponse.<List<ApplicationResponse>>builder()
                .result(applicationService.getAllApplications())
                .build();
    }
}
