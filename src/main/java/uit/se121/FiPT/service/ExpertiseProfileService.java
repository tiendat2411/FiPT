package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.ExpertiseProfileRequest.ExpertiseProfileCreationRequest;
import uit.se121.FiPT.dto.request.ExpertiseProfileRequest.UpdateExpertiseProfileRequest;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.ExpertiseProfileRespone.ExpertiseProfileResponse;
import uit.se121.FiPT.entity.ExpertiseProfile;
import uit.se121.FiPT.mapper.ExpertiseProfileMapper;
import uit.se121.FiPT.repository.ExpertiseProfileRepository;
import uit.se121.FiPT.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ExpertiseProfileService {
    ExpertiseProfileRepository expertiseProfileRepository;
    UserRepository userRepository;

    ExpertiseProfileMapper expertiseProfileMapper;

    public ExpertiseProfileResponse createExpertiseProfile(ExpertiseProfileCreationRequest request) {
        ExpertiseProfile expertiseProfile = expertiseProfileMapper.toExpertiseProfile(request);

        expertiseProfile.setUser(userRepository.findById(request.getUser()).get());
        expertiseProfileRepository.save(expertiseProfile);
        return expertiseProfileMapper.toExpertiseProfileResponse(expertiseProfile);
    }

    public ExpertiseProfileResponse getExpertiseProfile(String userId) {
        ExpertiseProfile expertiseProfile = expertiseProfileRepository.findByUser_Id(userId);
        return expertiseProfileMapper.toExpertiseProfileResponse(expertiseProfile);
    }

    public ExpertiseProfileResponse updateExpertiseProfile(UpdateExpertiseProfileRequest request, String userId) {
        ExpertiseProfile expertiseProfile = expertiseProfileRepository.findByUser_Id(userId);

        expertiseProfileMapper.updateExpertiseProfile(expertiseProfile, request);
        expertiseProfileRepository.save(expertiseProfile);

        return expertiseProfileMapper.toExpertiseProfileResponse(expertiseProfile);
    }
}