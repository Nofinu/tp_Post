package com.example.tpvendredi_07_07.dto.Dislike;

import com.example.tpvendredi_07_07.dto.Like.LikeCreateDto;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.entity.Like;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.DtoService.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DIslikeDtoToDIslike {

    @Autowired
    private DtoService dtoService;
    public Dislike convert (DislikeCreateDto dislikeCreateDto) throws NotFounfException {
        Dislike dislike = dislikeCreateDto.getId() != null ? dtoService.findDislikeById(dislikeCreateDto.getId()) : new Dislike();
        dislike.setDate(LocalDate.parse(dislikeCreateDto.getDate()));
        dislike.setComment(dtoService.findComment(dislikeCreateDto.getComment()));
        dislike.setUser(dtoService.findUser(dislikeCreateDto.getUser()));
        return dislike;

    }
}
