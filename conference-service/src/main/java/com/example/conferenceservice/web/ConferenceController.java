package com.example.conferenceservice.web;

import com.example.conferenceservice.clients.KeynoteRestClient;
import com.example.conferenceservice.entities.Conference;
import com.example.conferenceservice.entities.Review;
import com.example.conferenceservice.models.Keynote;
import com.example.conferenceservice.repositories.ConferenceRepository;
import com.example.conferenceservice.repositories.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {
    private final ConferenceRepository conferenceRepository;
    private final ReviewRepository reviewRepository;
    private final KeynoteRestClient keynoteRestClient;

    public ConferenceController(ConferenceRepository conferenceRepository, ReviewRepository reviewRepository, KeynoteRestClient keynoteRestClient) {
        this.conferenceRepository = conferenceRepository;
        this.reviewRepository = reviewRepository;
        this.keynoteRestClient = keynoteRestClient;
    }

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Conference getConferenceById(@PathVariable Long id) {
        Conference conference = conferenceRepository.findById(id).orElse(null);
        if (conference != null && conference.getKeynoteId() != null) {
            Keynote keynote = keynoteRestClient.getKeynoteById(conference.getKeynoteId());
            conference.setKeynote(keynote);
        }
        return conference;
    }

    @PostMapping
    public Conference saveConference(@RequestBody Conference conference) {
        return conferenceRepository.save(conference);
    }

    @PostMapping("/{id}/reviews")
    public Review addReview(@PathVariable Long id, @RequestBody Review review) {
        Conference conference = conferenceRepository.findById(id).orElse(null);
        if (conference != null) {
            review.setConference(conference);
            return reviewRepository.save(review);
        }
        return null;
    }
}
