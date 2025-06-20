package com.SavePoint.SavePoint.mapper;

import com.SavePoint.SavePoint.controller.request.GameRequest;
import com.SavePoint.SavePoint.controller.request.ReviewRequest;
import com.SavePoint.SavePoint.controller.response.CategoryResponse;
import com.SavePoint.SavePoint.controller.response.GameResponse;
import com.SavePoint.SavePoint.controller.response.ReviewResponse;
import com.SavePoint.SavePoint.entity.Category;
import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.entity.Review;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GameMapper {
    public static Game toGame (GameRequest request){

        List<Review> reviews = request.reviews().stream()
                .map(reviewId ->  Review.builder().id(reviewId).build())
                .toList();

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build() )
                .toList();

        return Game.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .developer(request.developer())
                .platform(request.plataform())
                .reviewList(reviews)
                .categoryList(categories)
                .build();
    }

    public GameResponse toGameResponse (Game game){
        List<ReviewResponse> reviews = game.getReviewList().stream()
                .map(ReviewMapper::toReviewResponse)
                .toList();

        List<CategoryResponse> categories = game.getCategoryList().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();


        return GameResponse.builder()
                .id(game.getId())
                .title(game.getTitle())
                .description(game.getDescription())
                .releaseDate(game.getReleaseDate())
                .plataform(game.getPlatform())
                .developer(game.getDeveloper())
                .reviews(reviews)
                .categories(categories)
                .build();
    }
}
