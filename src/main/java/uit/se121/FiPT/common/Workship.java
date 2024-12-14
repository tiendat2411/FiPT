package uit.se121.FiPT.common;

import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Embeddable
@Data
public class Workship {
    private LocalTime startTime;

    private LocalTime endTime;

    private DayOfWeek day;
}
