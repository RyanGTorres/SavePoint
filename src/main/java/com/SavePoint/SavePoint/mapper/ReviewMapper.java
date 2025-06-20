package com.SavePoint.SavePoint.mapper;

import com.SavePoint.SavePoint.controller.request.ReviewRequest;
import com.SavePoint.SavePoint.controller.response.GameSimpleResponse;
import com.SavePoint.SavePoint.controller.response.ReviewResponse;
import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.entity.Review;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReviewMapper {
    public static Review toReview(ReviewRequest reviewRequest){

        return Review.builder()
                .title(reviewRequest.title())
                .content(reviewRequest.content())
                .date(reviewRequest.date())
                .rating(reviewRequest.rating())
                .game(reviewRequest.game()
                )
                .build();
    }


    public static ReviewResponse toReviewResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .date(review.getDate())
                .rating(review.getRating())
                .game(
                        GameSimpleResponse.builder()
                                .id(review.getGame().getId())
                                .title(review.getGame().getTitle())
                                .build()
                )
                .build();
    }

}
