package com.SavePoint.SavePoint.mapper;

import com.SavePoint.SavePoint.controller.request.CategoryRequest;
import com.SavePoint.SavePoint.controller.response.CategoryResponse;
import com.SavePoint.SavePoint.entity.Category;
import com.SavePoint.SavePoint.entity.Review;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .gender(categoryRequest.gender())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .gender(category.getGender())
                .build();
    }
}
