package com.example.conferenceservice.repositories;

import com.example.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
