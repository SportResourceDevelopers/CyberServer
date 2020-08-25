package com.cyber.repository;

import com.cyber.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByAuthor(@Param("author") String author);

    List<Review> findByRating(@Param("rating") Byte rating);
}
