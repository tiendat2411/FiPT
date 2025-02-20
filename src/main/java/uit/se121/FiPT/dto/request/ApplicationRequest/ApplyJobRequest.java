package uit.se121.FiPT.dto.request.ApplicationRequest;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplyJobRequest {
    String user;
    String job;
    String cvUrls;
}
