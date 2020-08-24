package com.cyber.controller;

import com.cyber.domain.Review;
import com.cyber.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseEntity<List<Review>> getAllReview() {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> optionalReview = reviewService.getById(id);
        if (optionalReview.isPresent()) {
            return ResponseEntity.ok(optionalReview.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<Review>> getReviewByAuthor(@PathVariable String author) {
        List<Review> listByAuthor = reviewService.getByAuthor(author);
        if (listByAuthor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listByAuthor);

    }

    @GetMapping("/{rating}")
    public ResponseEntity<List<Review>> getReviewByRating(@PathVariable Byte rating) {
        List<Review> listByRating = reviewService.getByRating(rating);
        if (listByRating.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listByRating);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.save(review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
