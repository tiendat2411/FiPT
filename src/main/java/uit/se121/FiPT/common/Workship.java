package uit.se121.FiPT.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
public class Workship {

    private String startTime;

    private String endTime;

    private String day;
}
