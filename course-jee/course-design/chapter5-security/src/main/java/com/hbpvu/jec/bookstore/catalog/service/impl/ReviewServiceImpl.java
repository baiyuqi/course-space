package com.hbpvu.jec.bookstore.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.catalog.repository.ReviewRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Review;
import com.hbpvu.jec.bookstore.catalog.service.ProductService;
import com.hbpvu.jec.bookstore.catalog.service.ReviewService;
import com.hbpvu.jec.bookstore.catalog.web.CreateOrUpdateReviewRequest;
import com.hbpvu.jec.bookstore.catalog.web.ProductResponse;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Devaraj Reddy, Date : 08-Nov-2020
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    @Autowired
    ProductService productService;

    @Override
    public void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String userIdFromToken = authentication.getName();
        String userNameFromToken = authentication.getName();

        //check whether product exists.
        ProductResponse product = productService.getProduct(createOrUpdateReviewRequest.getProductId());
        if (product == null) {
            throw new RuntimeException("Product doesn't exist!");
        }

        Optional<Review> review = reviewRepository.findByUserIdAndProductId(userIdFromToken, createOrUpdateReviewRequest.getProductId());

        if (review.isPresent()) {
            Review updatedReview = review.get();
            updatedReview.setRatingValue(createOrUpdateReviewRequest.getRatingValue());
            updatedReview.setReviewMessage(createOrUpdateReviewRequest.getReviewMessage());
            reviewRepository.save(updatedReview);
        } else {
            Review newReview = Review.builder()
                    .reviewMessage(createOrUpdateReviewRequest.getReviewMessage())
                    .ratingValue(createOrUpdateReviewRequest.getRatingValue())
                    .userId(userIdFromToken)
                    .userName(userNameFromToken)
                    .productId(createOrUpdateReviewRequest.getProductId())
                    .build();
            reviewRepository.save(newReview);
        }
    }

    @Override
    public List<Review> getReviewsForProduct(String productId) {

        Optional<List<Review>> reviewsForProduct = reviewRepository.findAllByProductId(productId);
        return reviewsForProduct.orElseGet(ArrayList::new);

    }
}
