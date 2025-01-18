package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import uit.se121.FiPT.common.ExpertiseSkill;
import uit.se121.FiPT.common.PersonalNeed;
import uit.se121.FiPT.common.SoftSkill;
import uit.se121.FiPT.common.Workship;
import uit.se121.FiPT.dto.request.AdvancedProfile.AdvancedProfileCreationRequest;
import uit.se121.FiPT.dto.request.AdvancedProfile.AdvancedProfileRequest;
import uit.se121.FiPT.dto.response.AdvancedProfile.AdvancedProfileResponse;
import uit.se121.FiPT.entity.AdvancedProfile;
import uit.se121.FiPT.repository.MajorRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class AdvancedProfileMapper {
    UserRepository userRepository;
    MajorRepository majorRepository;

    public AdvancedProfile toAdvancedProfile(AdvancedProfileRequest request) {
        List<String> workingTime;
        return AdvancedProfile.builder()
                .user(userRepository.getById(request.getUser()))
                .yearCollege(request.getYearCollege())
                .major(majorRepository.getById(request.getMajor()))
                .address(request.getAddress())
                .build();
    }


    public AdvancedProfile toAdvancedProfileCreation(AdvancedProfileCreationRequest request) {
        List<Workship> workshipList = new ArrayList<>();

        var workships = request.getWorkingTime();
        for (int i = 0; i < workships.size(); i += 3) {
            try {
                LocalTime startTime = LocalTime.parse(workships.get(i));
                LocalTime endTime = LocalTime.parse(workships.get(i + 1));
                DayOfWeek day = DayOfWeek.valueOf(workships.get(i + 2).toUpperCase());

                Workship workship = new Workship(startTime, endTime, day);

                workshipList.add(workship);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error parsing workship at index " + i + ": " + e.getMessage(), e);
            }
        }

        SoftSkill softSkill = SoftSkill.builder()
                .commnunicationSkill(request.getCommnunicationSkill())
                .collaborationSkill(request.getCollaborationSkill())
                .networkingSkill(request.getNetworkingSkill())
                .problemSolvingSkill(request.getProblemSolvingSkill())
                .build();
        ExpertiseSkill expertiseSkill = ExpertiseSkill.builder()
                .skillScore1(request.getSkillScore1())
                .skillScore2(request.getSkillScore2())
                .skillScore3(request.getSkillScore3())
                .build();
        PersonalNeed personalNeed = PersonalNeed.builder()
                .suitableTime(request.getSuitableTime())
                .wage(request.getWage())
                .build();

        return AdvancedProfile.builder()
                .user(userRepository.getById(request.getUser()))
                .major(majorRepository.getById(request.getMajor()))
                .address(request.getAddress())
                .workingTime(workshipList)
                .softSkill(softSkill)
                .expertiseSkill(expertiseSkill)
                .personalNeed(personalNeed)
                .build();
    }

    public AdvancedProfileResponse toAdvancedProfileResponse(AdvancedProfile advancedProfile){
        return AdvancedProfileResponse.builder()
                .user(advancedProfile.getUser().getFirstName() + " " + advancedProfile.getUser().getLastName())
                .major(advancedProfile.getMajor().getName())
                .address(advancedProfile.getAddress())
                .yearCollege(advancedProfile.getYearCollege())
                .build();
    }

}
