package com.SavePoint.SavePoint.service;

import com.SavePoint.SavePoint.controller.request.ReviewRequest;
import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.entity.Review;
import com.SavePoint.SavePoint.mapper.ReviewMapper;
import com.SavePoint.SavePoint.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;


}
