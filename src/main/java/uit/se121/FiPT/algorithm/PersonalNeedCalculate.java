package uit.se121.FiPT.algorithm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se121.FiPT.common.Workship;
import uit.se121.FiPT.dto.CalculateParameter.N_Score.PersonalNeedCalculateDto;
import uit.se121.FiPT.dto.CalculateParameter.N_Score.PersonalNeedDto;
import uit.se121.FiPT.dto.CalculateParameter.N_Score.WorkingConditionsDto;

import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonalNeedCalculate {
    private int weight;

    public int calculateWageScore(int Wage) {
        if (Wage < 25000) return 1;
        else if (Wage <= 50000) return 2;
        else if (Wage <= 80000) return 3;
        else if (Wage <= 120000) return 4;
        return 5;
    }

    public static int calculateMatchPercentage(List<Workship> workships, List<Workship> availabilities) {
        double totalWorkHours = 0;
        double matchedHours = 0;

        for (Workship workship : workships) {
            double workshipHours = getDurationInHours(workship.getStartTime(), workship.getEndTime());
            totalWorkHours += workshipHours;

            // Tìm khoảng thời gian khớp trong lịch người dùng
            for (Workship availability : availabilities) {
                if (workship.getDay() == availability.getDay()) {
                    double overlapHours = getOverlapInHours(
                            workship.getStartTime(), workship.getEndTime(),
                            availability.getStartTime(), availability.getEndTime()
                    );
                    matchedHours += overlapHours;
                }
            }
        }

        double timeScore = totalWorkHours == 0 ? 0 : (matchedHours / totalWorkHours) * 100;

        if (timeScore < 0.2) return 1;
        else if (timeScore <= 0.4) return 2;
        else if (timeScore <= 0.6) return 3;
        else if (timeScore <= 0.8) return 4;
        return 5;
    }

    public static double getDurationInHours(LocalTime start, LocalTime end) {
        return (double) java.time.Duration.between(start, end).toMinutes() / 60;
    }

    public static double getOverlapInHours(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        LocalTime overlapStart = start1.isAfter(start2) ? start1 : start2;
        LocalTime overlapEnd = end1.isBefore(end2) ? end1 : end2;

        if (overlapStart.isBefore(overlapEnd)) {
            return getDurationInHours(overlapStart, overlapEnd);
        }
        return 0;
    }

    public PersonalNeedCalculateDto personalNeedCalculate(PersonalNeedDto personDto, WorkingConditionsDto jobDto) {
        int wageSocre = calculateWageScore(jobDto.getWage()) * weight * personDto.getWage();
        int timeScore = calculateMatchPercentage(personDto.getAvailabilities(), jobDto.getWork()) * personDto.getTime() * weight;
        return PersonalNeedCalculateDto.builder()
                .wageScore(wageSocre)
                .timeScore(timeScore)
                .totalValue(wageSocre + timeScore)
                .build();
    }
}
