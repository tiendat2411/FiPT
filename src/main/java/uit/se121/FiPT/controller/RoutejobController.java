package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.request.RouteJobRequest.RouteJobCreationRequest;
import uit.se121.FiPT.dto.request.RouteJobRequest.UpdateRouteJobRequest;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.RouteJobResponse.RouteJobResponse;
import uit.se121.FiPT.service.RouteJobService;

@RestController
@RequestMapping("/route-jobs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoutejobController {
    RouteJobService routeJobService;

    @PostMapping("/generate/{userId}")
    ApiResponse<RouteJobResponse> generateRouteJob(@RequestBody RouteJobCreationRequest request, @PathVariable String userId) {
        return ApiResponse.<RouteJobResponse>builder()
                .result(routeJobService.generateRouteJob(request, userId))
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<RouteJobResponse> getRouteJob(@PathVariable String userId) {
        return ApiResponse.<RouteJobResponse>builder()
                .result(routeJobService.getRouteJob(userId))
                .build();
    }

    @PutMapping("/userId")
    ApiResponse<RouteJobResponse> updateRouteJob(@PathVariable String userId, @RequestBody UpdateRouteJobRequest request) {
        return ApiResponse.<RouteJobResponse>builder()
                .result(routeJobService.updateRouteJob(userId, request))
                .build();
    }
}
