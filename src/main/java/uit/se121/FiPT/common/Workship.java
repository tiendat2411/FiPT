package uit.se121.FiPT.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workship {
    private LocalTime startTime;

    private LocalTime endTime;

    private DayOfWeek day;
}
