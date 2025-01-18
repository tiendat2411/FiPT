package uit.se121.FiPT.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uit.se121.FiPT.dto.request.JobRequest.WeightDto;
import uit.se121.FiPT.dto.response.ApiResponse;
import uit.se121.FiPT.dto.response.Job_Response.ProposedJobResponse;
import uit.se121.FiPT.service.ProposedJobService;

import java.util.List;

@RestController
@RequestMapping("/advanced-profile")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProposedJobController {
    ProposedJobService proposedJobService;

    @PostMapping
    ApiResponse<List<ProposedJobResponse>> getProposedJobs(@RequestBody WeightDto weightDto) {
        return ApiResponse.<List<ProposedJobResponse>>builder()
                .result(proposedJobService.getProposedJobs(weightDto))
                .build();
    }

    @PostMapping("/s")
    Double test(@RequestBody Double a) {
        System.out.println(a);
        return a;
    }
}
