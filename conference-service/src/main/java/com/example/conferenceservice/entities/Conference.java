package com.example.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String type; // académique ou commerciale
    private Date date;
    private int duree;
    private int inscrits;
    private double score;
    private Long keynoteId; // Foreign key to Keynote
    @Transient
    private Object keynote; // To store Keynote details from Feign
    @OneToMany(mappedBy = "conference")
    private List<Review> reviews;
}
