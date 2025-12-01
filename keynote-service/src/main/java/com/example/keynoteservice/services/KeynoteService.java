package com.example.keynoteservice.services;

import com.example.keynoteservice.entities.Keynote;
import com.example.keynoteservice.repositories.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeynoteService {
    private final KeynoteRepository keynoteRepository;

    public KeynoteService(KeynoteRepository keynoteRepository) {
        this.keynoteRepository = keynoteRepository;
    }

    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }

    public Keynote getKeynoteById(Long id) {
        return keynoteRepository.findById(id).orElse(null);
    }

    public Keynote saveKeynote(Keynote keynote) {
        return keynoteRepository.save(keynote);
    }
}
