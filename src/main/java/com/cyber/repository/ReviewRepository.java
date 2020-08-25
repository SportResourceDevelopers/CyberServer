package com.cyber.repository;

import com.cyber.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByAuthor(@Param("author") String author);

    List<Review> findByRating(@Param("rating") Byte rating);
}
