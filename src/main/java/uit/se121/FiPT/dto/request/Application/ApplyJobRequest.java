package uit.se121.FiPT.dto.request.Application;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.entity.User;

import java.time.LocalDateTime;

public class ApplyJobRequest {
    String user;
    String employer;
    String job;
    String date;
    String status;
    String cvUrls;
}
