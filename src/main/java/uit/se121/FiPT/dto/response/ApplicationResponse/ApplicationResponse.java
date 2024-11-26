package uit.se121.FiPT.dto.response.ApplicationResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationResponse {
    String user;
    String employer;
    String job;
    String date;
    String status;
    String cvUrls;
}
