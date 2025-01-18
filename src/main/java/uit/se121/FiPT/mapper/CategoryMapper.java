package uit.se121.FiPT.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uit.se121.FiPT.dto.response.Category_Response.CategoryResponse;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class CategoryMapper {
    CategoryRepository categoryRepository;

    public CategoryResponse toCategoryResponse(Category category){
        List<Job> jobs = category.getJobCategory();
        List<String> jobIds = jobs.stream()
                .map(Job::getId)
                .collect(Collectors.toList());

        return CategoryResponse.builder()
                .name(category.getName())
                .description(category.getDescription())
                .jobs(jobIds)
                .build();
    }
}
