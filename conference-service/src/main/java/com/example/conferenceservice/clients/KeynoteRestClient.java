package com.example.conferenceservice.clients;

import com.example.conferenceservice.models.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable Long id);
}
