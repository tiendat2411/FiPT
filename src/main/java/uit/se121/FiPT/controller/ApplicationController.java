package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uit.se121.FiPT.dto.request.Application.ApplyJobRequest;
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

     ApiResponse<ApplicationResponse> applyJob(@RequestBody ApplyJobRequest request) {
         return ApiResponse.<ApplicationResponse>builder()
                 .result(applicationService.applyJob(request))
                 .build();
     }

    ApiResponse<ApplicationResponse> approveApplication(@RequestParam String applicationId) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.approveApplication(applicationId))
                .build();
    }

    ApiResponse<ApplicationResponse> rejectApplication(@RequestParam String applicationId) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.rejectApplication(applicationId))
                .build();
    }

    ApiResponse<ApplicationResponse> underReviewApplication(@RequestParam String applicationId) {
        return ApiResponse.<ApplicationResponse>builder()
                .result(applicationService.underReviewApplication(applicationId))
                .build();
    }

    ApiResponse<List<ApplicationResponse>> getApplicationByEmployer(@RequestParam String employerId) {
        return ApiResponse.<List<ApplicationResponse>>builder()
                .result(applicationService.getAllApplicationsByEmployer(employerId))
                .build();
    }

    ApiResponse<List<ApplicationResponse>> getApplicationByUser(@RequestParam String userId) {
        return ApiResponse.<List<ApplicationResponse>>builder()
                .result(applicationService.getAllApplicationsByUser(userId))
                .build();
    }
    }
