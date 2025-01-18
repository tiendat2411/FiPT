package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.request.RouteJobRequest.RouteJobCreationRequest;
import uit.se121.FiPT.dto.request.RouteJobRequest.UpdateRouteJobRequest;
import uit.se121.FiPT.dto.response.RouteJobResponse.RouteJobResponse;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.entity.RouteJob;
import uit.se121.FiPT.entity.User;
import uit.se121.FiPT.mapper.RouteJobMapper;
import uit.se121.FiPT.repository.CategoryRepository;
import uit.se121.FiPT.repository.JobJpaRepository;
import uit.se121.FiPT.repository.RouteJobRepository;
import uit.se121.FiPT.repository.UserRepository;

import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RouteJobService {
    RouteJobRepository routeJobRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    JobJpaRepository jobRepository;

    RouteJobMapper routeJobMapper;

    public RouteJobResponse generateRouteJob(RouteJobCreationRequest request, String userId) {
        User user = userRepository.findById(userId).get();
        List<String> listCategoriesId = request.getProposedRoute();

        List<Category> listCategories =listCategoriesId.stream()
                .map(categoryId -> categoryRepository.findById(categoryId).get())
                .filter(category -> category != null)
                .collect(Collectors.toList());

        RouteJob routeJob = RouteJob.builder()
                .user(user)
                .duration(Period.ofDays(request.getDuration()))
                .proposedRoute(listCategories)
                .pointValue(request.getPointValue())
                .build();

        routeJobRepository.save(routeJob);

        return routeJobMapper.toRouteJobResponse(routeJob);
    }

    public RouteJobResponse getRouteJob(String routeJobId) {
        RouteJob routeJob = routeJobRepository.findById(routeJobId).get();

        return routeJobMapper.toRouteJobResponse(routeJob);
    }

    public RouteJobResponse updateRouteJob(String routeJobId, UpdateRouteJobRequest request) {
        RouteJob routeJob = routeJobRepository.findById(routeJobId).get();
        routeJob.setDuration(Period.ofDays(request.getDuration()));

        List<String> listCategoriesId = request.getProposedRoute();

        List<Category> listCategories =listCategoriesId.stream()
                .map(categoryId -> categoryRepository.findById(categoryId).get())
                .filter(category -> category != null)
                .collect(Collectors.toList());

        List<String> listJobId = request.getJobProcess();

        List<Job> listJob =listJobId.stream()
                .map(jobId -> jobRepository.findById(jobId).get())
                .filter(job-> job != null)
                .collect(Collectors.toList());

        routeJob.setProposedRoute(listCategories);
        routeJob.setJobProcess(listJob);
        routeJob.setPointValue(request.getPointValue());

        routeJobRepository.save(routeJob);
        return routeJobMapper.toRouteJobResponse(routeJob);
    }
}
