package uit.se121.FiPT.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uit.se121.FiPT.dto.response.Category_Response.CategoryResponse;
import uit.se121.FiPT.entity.Category;
import uit.se121.FiPT.entity.Job;
import uit.se121.FiPT.mapper.CategoryMapper;
import uit.se121.FiPT.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public List<CategoryResponse> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        List<CategoryResponse> categoriesResponse = new ArrayList<>();
        for (Category category : categories) {
            categoriesResponse.add(categoryMapper.toCategoryResponse(category));
        }

        return categoriesResponse;
    }

}
