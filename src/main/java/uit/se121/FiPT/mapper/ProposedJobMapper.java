package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import uit.se121.FiPT.common.Workship;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillJobDto;
import uit.se121.FiPT.dto.calculateParameter.E_Score.MajorExpertiseSkillDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.PersonalNeedDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.WorkingConditionsDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillJobDto;
import uit.se121.FiPT.dto.calculateParameter.TotalValueJobDto;
import uit.se121.FiPT.dto.response.Job_Response.ProposedJobResponse;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.entity.JobValue;
import uit.se121.FiPT.entity.Major;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public class ProposedJobMapper {
    public SoftSkillJobDto toSoftSkillJobDto(JobValue jobValue){
        return SoftSkillJobDto.builder()
                .commnunicationSkill(jobValue.getCommnunicationSkill())
                .collaborationSkill(jobValue.getCollaborationSkill())
                .problemSolvingSkill(jobValue.getProblemSolvingSkill())
                .networkingSkill(jobValue.getNetworkingSkill())
                .build();
    }

    public ExpertiseSkillJobDto toExpertiseSkillJobDto(JobValue jobValue){
        return ExpertiseSkillJobDto.builder()
                .skillName1(jobValue.getMainExpertiseSkill1())
                .skillName2(jobValue.getMainExpertiseSkill2())
                .skillName3(jobValue.getMainExpertiseSkill3())
                .expertiseSkill1(jobValue.getExpertiseSkill1())
                .expertiseSkill2(jobValue.getExpertiseSkill2())
                .expertiseSkill3(jobValue.getExpertiseSkill3())
                .build();
    }

    public MajorExpertiseSkillDto toMajorExpertiseSkillDto(Major major){
        return MajorExpertiseSkillDto.builder()
                .exSkill1(major.getExpertiseSkillName1())
                .exSkill2(major.getExpertiseSkillName2())
                .exSkill3(major.getExpertiseSkillName3())
                .build();
    }

    public PersonalNeedDto toPersonalNeedDto(Major major, List<Workship> workships){
        List<Workship> workshipList = new ArrayList<>();

//        for (int i = 0; i < workships.size(); i += 3) {
//            try {
//                // Parse start time
//                LocalTime startTime = LocalTime.parse(workships.get(i));
//
//                // Parse end time
//                LocalTime endTime = LocalTime.parse(workships.get(i + 1));
//
//                // Parse day of week (convert to uppercase for DayOfWeek enum)
//                DayOfWeek day = DayOfWeek.valueOf(workships.get(i + 2).toUpperCase());
//
//                // Create a new Workship object
//                Workship workship = new Workship(startTime, endTime, day);
//
//                // Add to result list
//                workshipList.add(workship);
//            } catch (Exception e) {
//                throw new IllegalArgumentException("Error parsing workship at index " + i + ": " + e.getMessage(), e);
//            }
//        }

        return PersonalNeedDto.builder()
                .time(major.getTime())
                .wage(major.getWage())
                .availabilities(workships)
                .build();
    }

    public WorkingConditionsDto toWorkingConditionsDto(Job job){
//        List<Workship> workshipList = new ArrayList<>();

//        for (int i = 0; i < workships.size(); i += 3) {
//            try {
//                // Parse start time
//                LocalTime startTime = LocalTime.parse(workships.get(i));
//
//                // Parse end time
//                LocalTime endTime = LocalTime.parse(workships.get(i + 1));
//
//                // Parse day of week (convert to uppercase for DayOfWeek enum)
//                DayOfWeek day = DayOfWeek.valueOf(workships.get(i + 2).toUpperCase());
//
//                // Create a new Workship object
//                Workship workship = new Workship(startTime, endTime, day);
//
//                // Add to result list
//                workshipList.add(workship);
//            } catch (Exception e) {
//                throw new IllegalArgumentException("Error parsing workship at index " + i + ": " + e.getMessage(), e);
//            }
//        }

        return WorkingConditionsDto.builder()
                .wage(job.getWage())
                .work(job.getSchedule())
                .build();
    }

    public ProposedJobResponse toProposedJobResponse(Job job, TotalValueJobDto totalValueJobDto){
        String name;
        String description;
        String jobCategory;
        int wage;
        String address;
        String employerName;
        String detailUrls;

        SoftSkillCalculateDto sScore;
        ExpertiseSkillCalculateDto eScore;
        PersonalNeedCalculateDto nScore;
        int totalSocre;

        return ProposedJobResponse.builder()
                .name(job.getName())
                .description(job.getDescription())
                .jobCategory(job.getJobCategory().getName())
                .wage(job.getWage())
                .address(job.getAddress())
                .employerName(job.getEmployer().getName())
                .sScore(totalValueJobDto.getSScore())
                .eScore(totalValueJobDto.getEScore())
                .nScore(totalValueJobDto.getNScore())
                .totalSocre(totalValueJobDto.getTotalSocre())
                .build();
    }
}
