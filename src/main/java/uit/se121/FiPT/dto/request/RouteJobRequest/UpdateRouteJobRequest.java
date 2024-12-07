package uit.se121.FiPT.dto.request.RouteJobRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateRouteJobRequest {
    Integer duration;
    List<String> jobProcess;
    List<String> proposedRoute;
    List<Integer> pointValue;
}
