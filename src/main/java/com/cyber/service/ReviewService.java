package com.cyber.service;

import com.cyber.domain.Review;
import com.cyber.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Optional<Review> getById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public List<Review> getByAuthor(String author) {
        return reviewRepository.findByAuthor(author);
    }

    public List<Review> getByRating(Byte rating) {
        return reviewRepository.findByRating(rating);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
