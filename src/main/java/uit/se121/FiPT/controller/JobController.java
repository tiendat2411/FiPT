package uit.se121.FiPT.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.request.JobRequest.JobCreationRequest;
import uit.se121.FiPT.dto.response.Job_Response.JobResponse;
import uit.se121.FiPT.service.JobService;

import java.util.List;


@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobController {
    JobService jobService;

    @GetMapping("/all-jobs")
    ApiResponse<List<JobResponse>> getAll() {
        return ApiResponse.<List<JobResponse>>builder()
                .result(jobService.getAllJobs())
                .build();
    }

//    @GetMapping
//    ApiResponse<Page<JobResponse>> findAll(@PageableDefault(size = 5, sort = "recruitedDate", direction = org.springframework.data.domain.Sort.Direction.DESC) Pageable pageable) {
//        return ApiResponse.<Page<JobResponse>>builder()
//                .result(jobService.getJobs(pageable))
//                .build();
//    }

    @GetMapping
    public ApiResponse<Page<JobResponse>> getJobs(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer wage,
            @RequestParam(required = false) String employer
    ) {
        Page<JobResponse> jobs = jobService.getJobs(page, size, search, category, wage, employer);
        return ApiResponse.<Page<JobResponse>>builder()
                .result(jobs)
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

    @GetMapping("/{jobId}")
    ApiResponse<JobResponse> getJob(@PathVariable("jobId") String id) {
        return ApiResponse.<JobResponse>builder()
                .result(jobService.getJob(id))
                .build();
    }
}
