package com.example.keynoteservice.web;

import com.example.keynoteservice.entities.Keynote;
import com.example.keynoteservice.services.KeynoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keynotes")
public class KeynoteController {
    private final KeynoteService keynoteService;

    public KeynoteController(KeynoteService keynoteService) {
        this.keynoteService = keynoteService;
    }

    @GetMapping
    public List<Keynote> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @GetMapping("/{id}")
    public Keynote getKeynoteById(@PathVariable Long id) {
        return keynoteService.getKeynoteById(id);
    }

    @PostMapping
    public Keynote saveKeynote(@RequestBody Keynote keynote) {
        return keynoteService.saveKeynote(keynote);
    }
}
