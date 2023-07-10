package com.example.tpvendredi_07_07.dto.Post;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;

    @NotNull(message = "invalide title, title null")
    @NotEmpty(message = "invalide title, title empty")
    @Max(value = 15, message = "invalide title, title too long max 15")
    private String title;
    @NotNull(message = "invalide content, content null")
    @NotEmpty(message = "invalide content, content empty")
    @Max(value = 250, message = "invalide content, title too long max 250")
    private String content;
}
