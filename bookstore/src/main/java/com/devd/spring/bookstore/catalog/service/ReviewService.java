package com.devd.spring.bookstore.catalog.service;

import java.util.List;

import com.devd.spring.bookstore.catalog.repository.dao.Review;
import com.devd.spring.bookstore.catalog.web.CreateOrUpdateReviewRequest;

/**
 * @author Devaraj Reddy, Date : 08-Nov-2020
 */
public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForProduct(String productId);

}
