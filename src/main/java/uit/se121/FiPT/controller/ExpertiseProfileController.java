package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.se121.FiPT.dto.request.ExpertiseProfileRequest.ExpertiseProfileCreationRequest;
import uit.se121.FiPT.dto.request.ExpertiseProfileRequest.UpdateExpertiseProfileRequest;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.ExpertiseProfileRespone.ExpertiseProfileResponse;
import uit.se121.FiPT.mapper.ExpertiseProfileMapper;
import uit.se121.FiPT.service.ExpertiseProfileService;

@RestController
@RequestMapping("/expertise-profile")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpertiseProfileController {
    ExpertiseProfileService expertiseProfileService;

    ExpertiseProfileMapper  expertiseProfileMapper;

    ApiResponse<ExpertiseProfileResponse> createExpertiseProfile(ExpertiseProfileCreationRequest request) {
        return ApiResponse.<ExpertiseProfileResponse>builder()
                .result(expertiseProfileService.createExpertiseProfile(request))
                .build();
    }

    ApiResponse<ExpertiseProfileResponse> updateExpertiseProfile(UpdateExpertiseProfileRequest request, String userId) {
        return ApiResponse.<ExpertiseProfileResponse>builder()
                .result(expertiseProfileService.updateExpertiseProfile(request, userId))
                .build();
    }

    ApiResponse<ExpertiseProfileResponse> getExpertiseProfile(String userId) {
        return ApiResponse.<ExpertiseProfileResponse>builder()
                .result(expertiseProfileService.getExpertiseProfile(userId))
                .build();
    }
}
