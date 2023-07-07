package com.example.tpvendredi_07_07.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "invalide title, title null")
    @NotEmpty(message = "invalide title, title empty")
    @Max(value = 15, message = "invalide title, title too long max 15")
    private String title;
    @NotNull(message = "invalide content, content null")
    @NotEmpty(message = "invalide content, content empty")
    @Max(value = 250, message = "invalide content, title too long max 250")
    private String content;

    @ManyToMany
    private List<Comment> comment;
}
