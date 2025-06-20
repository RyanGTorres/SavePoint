package com.SavePoint.SavePoint.service;

import com.SavePoint.SavePoint.entity.Category;
import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.entity.Review;
import com.SavePoint.SavePoint.repository.CategoryRepository;
import com.SavePoint.SavePoint.repository.GameRepository;
import com.SavePoint.SavePoint.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final CategoryService categoryService;
    private final ReviewService reviewService;

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Optional<Game> findById(Long id){
        return gameRepository.findById(id);
    }

    public ResponseEntity<Void> deleteById(Long id){
        gameRepository.deleteById(id);
        return null;
    }
    public Optional<Game> update (Long id, Game game){
        Optional<Game> byId = findById(id);
        if (byId.isPresent()){

            List<Category> categories = this.findCategory(game.getCategoryList());
            List<Review> reviews = this.findReview(game.getReviewList());

            Game gameUpdating = byId.get();

            gameUpdating.setTitle(game.getTitle());
            gameUpdating.setDeveloper(game.getDeveloper());
            gameUpdating.setReleaseDate(game.getReleaseDate());
            gameUpdating.setDescription(game.getDescription());

            game.getCategoryList().clear();
            game.getCategoryList().addAll(categories);

            game.getReviewList().clear();
            game.getReviewList().addAll(reviews);

            gameRepository.save(gameUpdating);
            return Optional.of(gameUpdating);
        }
        return Optional.empty();
    }

    public List<Category> findCategory(List<Category> categories){
        List<Category> listCategory = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(listCategory::add));
        return listCategory;
    }

    public List<Review> findReview(List<Review> reviews){
        List<Review> listReview = new ArrayList<>();
        reviews.forEach(review -> reviewService.findById(review.getId()).ifPresent(listReview::add) );
        return listReview;
    }
}
