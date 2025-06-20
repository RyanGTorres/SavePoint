package com.SavePoint.SavePoint.service;

import com.SavePoint.SavePoint.entity.Category;
import com.SavePoint.SavePoint.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
    public Category update(Long id, Category category){
        Optional<Category> optionalCategory = findById(id);
        if (optionalCategory.isPresent()){
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

}
