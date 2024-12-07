package uit.se121.FiPT.dto.response.RouteJobResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteJobResponse {
    String user;
    String duration;
    List<String> jobProcess;
    List<String> proposedRoute;
    List<Integer> pointValue;
}
