package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.response.Employer_Response.EmployerResponse;
import uit.se121.FiPT.entity.Employer;
import uit.se121.FiPT.mapper.EmployerMapper;
import uit.se121.FiPT.repository.EmployerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmployerService {
    EmployerRepository employerRepository;
    EmployerMapper employerMapper;

    public List<EmployerResponse> getAllEmployers() {
        return employerRepository.findAll().stream()
                .map(employerMapper::toEmployerResponse).toList();
    }
}
