package com.example.tpvendredi_07_07.dto.Like;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeCreateDto {

    private Integer id;

    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$",message = "Invalide Date : date must be yyyy-MM-dd")
    private String date;

    @NotNull(message = "Invalide user : user null")
    private Integer user;

    @NotNull(message = "Invalide comment : user null")
    private Integer comment;
}
