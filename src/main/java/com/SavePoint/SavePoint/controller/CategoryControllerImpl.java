package com.SavePoint.SavePoint.controller;

import com.SavePoint.SavePoint.controller.interfaces.CategoryController;
import com.SavePoint.SavePoint.controller.request.CategoryRequest;
import com.SavePoint.SavePoint.controller.response.CategoryResponse;
import com.SavePoint.SavePoint.entity.Category;
import com.SavePoint.SavePoint.mapper.CategoryMapper;
import com.SavePoint.SavePoint.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/savepoint/category")
@RequiredArgsConstructor

public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity <List<CategoryResponse>> findAll(){
        return ResponseEntity.ok(categoryService.findAll().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id){
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)) )
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity <CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }


    @PostMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @Valid @RequestBody CategoryRequest request){
        Category categoryAtualizada = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.update(id, categoryAtualizada);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);
        if (optCategory.isPresent()){
            categoryService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
