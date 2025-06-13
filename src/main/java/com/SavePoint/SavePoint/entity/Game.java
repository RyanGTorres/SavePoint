package com.SavePoint.SavePoint.entity;

import com.SavePoint.SavePoint.enums.Platform;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game")

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "developer")
    private String developer;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform")
    private Platform platform;

    @ManyToMany
    @JoinTable( name = "game_category",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn (name = "category_id")
    )
    private List<Category> categoryList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="game", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviewList;
}
