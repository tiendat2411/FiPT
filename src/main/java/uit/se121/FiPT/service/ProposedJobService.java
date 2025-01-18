package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.algorithm.ExpertiseSkillsCalculate;
import uit.se121.FiPT.algorithm.PersonalNeedCalculate;
import uit.se121.FiPT.algorithm.SoftSkillsCalculate;
import uit.se121.FiPT.algorithm.TotalValueJobCalculate;
import uit.se121.FiPT.dto.calculateParameter.E_Score.ExpertiseSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.S_Score.SoftSkillCalculateDto;
import uit.se121.FiPT.dto.calculateParameter.TotalValueJobDto;
import uit.se121.FiPT.dto.request.JobRequest.WeightDto;
import uit.se121.FiPT.dto.response.Job_Response.ProposedJobResponse;
import uit.se121.FiPT.entity.*;
import uit.se121.FiPT.exception.AppException;
import uit.se121.FiPT.exception.ErrorCode;
import uit.se121.FiPT.mapper.ProposedJobMapper;
import uit.se121.FiPT.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProposedJobService {
    JobJpaRepository jobRepository;
    AdvancedProfileRepository advancedProfileRepository;
    UserRepository userRepository;
    MajorRepository majorRepository;
    JobValueRepository jobValueRepository;

    ProposedJobMapper proposedJobMapper;

    public List<ProposedJobResponse> getProposedJobs(WeightDto weightRequest) throws AppException {
        List<ProposedJobResponse> proposedJobResponses = new ArrayList<>();

        SoftSkillsCalculate softSkillsCalculate = new SoftSkillsCalculate(weightRequest.getSweight());
        ExpertiseSkillsCalculate expertiseSkillsCalculate = new ExpertiseSkillsCalculate(weightRequest.getEweight());
        PersonalNeedCalculate personalNeedCalculate = new PersonalNeedCalculate(weightRequest.getNweight());
        TotalValueJobCalculate totalValueJobCalculate = new TotalValueJobCalculate();

        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByAccount_Username(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        Major major = majorRepository.getById(user.getAdvancedProfile().getMajor().getId());
        List<Job> candidateJobs = jobRepository.findAll();

        for (Job candidateJob : candidateJobs) {
            JobValue jobValue = candidateJob.getJobValue();

            SoftSkillCalculateDto sScore = softSkillsCalculate.calculateScore(major, proposedJobMapper.toSoftSkillJobDto(jobValue));
            ExpertiseSkillCalculateDto eScore = expertiseSkillsCalculate.calculateScore(proposedJobMapper.toExpertiseSkillJobDto(jobValue), proposedJobMapper.toMajorExpertiseSkillDto(major));
            PersonalNeedCalculateDto nScore = personalNeedCalculate.calculatePersonalNeed(proposedJobMapper.toPersonalNeedDto(major, user.getAdvancedProfile().getWorkingTime()), proposedJobMapper.toWorkingConditionsDto(candidateJob));
            TotalValueJobDto tScore = totalValueJobCalculate.calculateTotalValueJob(sScore, eScore, nScore);

            proposedJobResponses.add(ProposedJobResponse.builder()
                    .name(candidateJob.getName())
                    .description(candidateJob.getDescription())
                    .jobCategory(candidateJob.getJobCategory().getName())
                    .wage(candidateJob.getWage())
                    .address(candidateJob.getAddress())
                    .employerName(candidateJob.getEmployer().getName())
                    .sScore(sScore)
                    .eScore(eScore)
                    .nScore(nScore)
                    .totalSocre(tScore.getTotalSocre())
                    .build());
        }

        proposedJobResponses.sort((job1, job2) -> Double.compare(job2.getTotalSocre(), job1.getTotalSocre()));
        if (proposedJobResponses.size() > 20) {
            proposedJobResponses = proposedJobResponses.subList(0, 20);
        }

        return proposedJobResponses;
    }
}
