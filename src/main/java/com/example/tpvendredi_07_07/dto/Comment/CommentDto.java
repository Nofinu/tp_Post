package com.example.tpvendredi_07_07.dto.Comment;

import com.example.tpvendredi_07_07.entity.Post;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Integer id;

    @NotNull(message = "invalide message, message null")
    @NotEmpty(message = "invalide message, message empty")
    @Max(value = 500, message = "invalide message, title too long max 500")
    private String message;

    @Min(value = 0,message = "Incorectect post Id")
    private int post;
}
