package com.SavePoint.SavePoint.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private double rating;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private Game game;
}
