package uit.se121.FiPT.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.request.JobRequest.JobCreationRequest;
import uit.se121.FiPT.dto.response.JobResponse;
import uit.se121.FiPT.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobController {
    JobService jobService;

    @GetMapping
    ApiResponse<List<JobResponse>> getAll() {
        return ApiResponse.<List<JobResponse>>builder()
                .result(jobService.getAllJobs())
                .build();
    }

    @PostMapping
    ApiResponse<JobResponse> createJob(@RequestBody @Valid JobCreationRequest request) {
        return ApiResponse.<JobResponse>builder()
                .result(jobService.createJob(request))
                .build();
    }

    @DeleteMapping("/{jobId}")
    ApiResponse<Void> deleteJob(@PathVariable("jobId") String id) {
        jobService.deleteJob(id);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Job deleted succesfully")
                .build();
    }
}
