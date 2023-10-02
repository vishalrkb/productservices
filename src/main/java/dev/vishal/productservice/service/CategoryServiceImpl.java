package dev.vishal.productservice.service;

import dev.vishal.productservice.dto.CategoryDTO;
import dev.vishal.productservice.dto.GenericProductDTO;
import dev.vishal.productservice.model.Category;
import dev.vishal.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> response = new ArrayList<>();

        List<Category> categories = categoryRepository.findAll();

        for(Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();

            categoryDTO.setId(category.getId().toString());
            categoryDTO.setName(category.getName());

            response.add(categoryDTO);
        }

        return response;

    }

}
