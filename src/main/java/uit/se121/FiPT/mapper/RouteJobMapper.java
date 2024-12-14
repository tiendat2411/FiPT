package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import uit.se121.FiPT.dto.response.RouteJobResponse.RouteJobResponse;
import uit.se121.FiPT.entity.RouteJob;
import uit.se121.FiPT.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class RouteJobMapper {
   CategoryRepository categoryRepository;

    public RouteJobResponse toRouteJobResponse(RouteJob routeJob) {
        String userName = routeJob.getUser().getFirstName() + " " + routeJob.getUser().getLastName();
        String duration = routeJob.getDuration().toString();
        List<String> jobProcess = routeJob.getJobProcess().stream()
                .map( job -> job.getName())
                .filter(job -> job != null)
                .collect(Collectors.toList());

        List<String> proposedRoute = routeJob.getProposedRoute().stream()
                .map( category -> category.getName())
                .filter(category -> category != null)
                .collect(Collectors.toList());

        return RouteJobResponse.builder()
                .user(userName)
                .duration(duration)
                .jobProcess(jobProcess)
                .proposedRoute(proposedRoute)
                .pointValue(routeJob.getPointValue())
                .build();
    }
}
