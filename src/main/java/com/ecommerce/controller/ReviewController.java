package com.ecommerce.controller;

import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Review;
import com.ecommerce.model.User;
import com.ecommerce.request.ReviewRequest;
import com.ecommerce.service.ReviewService;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review>createReview(@RequestBody ReviewRequest reviewRequest, @RequestHeader("Authorization")String jwt)throws UserException, ProductException{
        User user=userService.findUserProfileByJwt(jwt);
        Review review=reviewService.createReview(reviewRequest, user);
        return new  ResponseEntity<>(review, HttpStatus.CREATED);
    }
    @PostMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductReview(@PathVariable Long productId) throws UserException, ProductException{
        List<Review> reviews = reviewService.getAllReview(productId);
        return new ResponseEntity<>(reviews, HttpStatus.ACCEPTED);
    }

}
