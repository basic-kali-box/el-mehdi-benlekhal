package com.example.conferenceservice.repositories;

import com.example.conferenceservice.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
