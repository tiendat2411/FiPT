package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.se121.FiPT.dto.request.AdvancedProfile.AdvancedProfileCreationRequest;
import uit.se121.FiPT.dto.response.AdvancedProfile.AdvancedProfileResponse;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.service.AdvancedProfileService;

@RestController
@RequestMapping("/advanced-profile")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdvancedProfileController {
    AdvancedProfileService advancedProfileService;

    ApiResponse<AdvancedProfileResponse> createAdvancedProfile(AdvancedProfileCreationRequest request) {
        return ApiResponse.<AdvancedProfileResponse>builder()
                .result(advancedProfileService.createAdvancedProfile(request))
                .build();
    }

//    ApiResponse<AdvancedProfileResponse> updateExpertiseProfile(UpdateExpertiseProfileRequest request, String userId) {
//        return ApiResponse.<ExpertiseProfileResponse>builder()
//                .result(advancedProfileService.updateExpertiseProfile(request, userId))
//                .build();
//    }

    ApiResponse<AdvancedProfileResponse> getAdvancedProfile(String userId) {
        return ApiResponse.<AdvancedProfileResponse>builder()
                .result(advancedProfileService.getAdvancedProfile(userId))
                .build();
    }
}
