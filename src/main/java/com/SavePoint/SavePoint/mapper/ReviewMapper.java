package com.SavePoint.SavePoint.mapper;

import com.SavePoint.SavePoint.controller.request.GameRequest;
import com.SavePoint.SavePoint.controller.request.ReviewRequest;
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
                .title(reviewRequest.title())
                .game(reviewRequest.gameId())
                .build()
    }
}
