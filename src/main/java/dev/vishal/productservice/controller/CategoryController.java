package dev.vishal.productservice.controller;

import dev.vishal.productservice.dto.CategoryDTO;
import dev.vishal.productservice.dto.GenericProductDTO;
import dev.vishal.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    CategoryService categoryService;

    @Lazy
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(
                categoryService.getAllCategories(),
                HttpStatus.OK
        );

    }


}
