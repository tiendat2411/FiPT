package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.AdvancedProfile.AdvancedProfileCreationRequest;
import uit.se121.FiPT.dto.response.AdvancedProfile.AdvancedProfileResponse;
import uit.se121.FiPT.entity.AdvancedProfile;
import uit.se121.FiPT.mapper.AdvancedProfileMapper;
import uit.se121.FiPT.repository.AdvancedProfileRepository;
import uit.se121.FiPT.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AdvancedProfileService {
    AdvancedProfileRepository advancedProfileRepository;
    UserRepository userRepository;

    AdvancedProfileMapper advancedProfileMapper;

    public AdvancedProfileResponse createAdvancedProfile(AdvancedProfileCreationRequest request) {
        AdvancedProfile expertiseProfile = advancedProfileMapper.toAdvancedProfileCreation(request);

        expertiseProfile.setUser(userRepository.findById(request.getUser()).get());
        advancedProfileRepository.save(expertiseProfile);
        return advancedProfileMapper.toAdvancedProfileResponse(expertiseProfile);
    }

    public AdvancedProfileResponse getAdvancedProfile(String userId) {
        AdvancedProfile advancedProfile = advancedProfileRepository.findByUser_Id(userId);
        return advancedProfileMapper.toAdvancedProfileResponse(advancedProfile);
    }

//    public AdvancedProfileResponse updateAdvancedProfile(AdvancedProfileCreationRequest request, String userId) {
//        AdvancedProfile expertiseProfile = advancedProfileRepository.findByUser_Id(userId);
//        User user = userRepository.findById(userId).get();
//        expertiseProfileMapper.updateExpertiseProfile(expertiseProfile, request);
//        expertiseProfile.setUser(user);
//        advancedProfileRepository.save(expertiseProfile);
//
//        return expertiseProfileMapper.toExpertiseProfileResponse(expertiseProfile);
//    }
}
