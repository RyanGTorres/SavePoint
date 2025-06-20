package com.SavePoint.SavePoint.controller;


import com.SavePoint.SavePoint.controller.request.ReviewRequest;
import com.SavePoint.SavePoint.controller.response.ReviewResponse;
import com.SavePoint.SavePoint.entity.Review;
import com.SavePoint.SavePoint.mapper.GameMapper;
import com.SavePoint.SavePoint.mapper.ReviewMapper;
import com.SavePoint.SavePoint.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/savepoint/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> findAll() {
        return ResponseEntity.ok(
                reviewService.findAll().stream()
                        .map(ReviewMapper::toReviewResponse)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> findById(@PathVariable Long id){

        return reviewService.findById(id)
                .map(review -> ResponseEntity.ok(ReviewMapper.toReviewResponse(review)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> save(@RequestBody ReviewRequest request){
        Review reviewSaved = ReviewMapper.toReview(request);
        Review reviewResponse = reviewService.save(reviewSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(ReviewMapper.toReviewResponse(reviewResponse));
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<ReviewResponse> update(@PathVariable Long id, @RequestBody ReviewRequest request){
//        return reviewService.update(id , GameMapper.toGame(request))
//                .map(movie -> ResponseEntity.ok(GameMapper.toGameResponse(movie)))
//                .orElse(ResponseEntity.notFound().build());    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        Optional<Review> optional = reviewService.findById(id);
        if (optional.isPresent()){
            reviewService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
