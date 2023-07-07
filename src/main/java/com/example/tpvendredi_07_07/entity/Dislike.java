package com.example.tpvendredi_07_07.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "dislike_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Comment comment;
}