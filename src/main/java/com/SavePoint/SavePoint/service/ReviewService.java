package com.SavePoint.SavePoint.service;


import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.entity.Review;
import com.SavePoint.SavePoint.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private GameService gameService;


    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    }

    public Review save(Review review){
        return reviewRepository.save(review);
    }

    public Optional<Review> update(Long id, Review review){
        Optional<Review> optionalReview = findById(id);

        if (optionalReview.isPresent()){
            Review reviewToUpdate = optionalReview.get();

            reviewToUpdate.setId(id);
            reviewToUpdate.setTitle(review.getTitle());
            reviewToUpdate.setDate(review.getDate());
            reviewToUpdate.setGame(review.getGame());
            reviewToUpdate.setRating(review.getRating());
            reviewToUpdate.setContent(review.getContent());

            if (review.getGame() != null && review.getGame().getId() != null) {
                Game game = new Game();
                game.setId(review.getGame().getId());
                reviewToUpdate.setGame(game);
            }

            reviewRepository.save(reviewToUpdate);
            return Optional.of(reviewToUpdate);

        }
        return Optional.empty();
    }


    public void delete (Long id){
        reviewRepository.deleteById(id);
    }
}
