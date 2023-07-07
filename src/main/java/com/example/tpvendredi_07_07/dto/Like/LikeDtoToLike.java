package com.example.tpvendredi_07_07.dto.Like;

import com.example.tpvendredi_07_07.entity.Like;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.DtoService.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LikeDtoToLike {

    @Autowired
    private DtoService dtoService;
    public Like convert (LikeCreateDto likeCreateDto) throws NotFounfException {
        Like like = likeCreateDto.getId() != null ? dtoService.findLikeById(likeCreateDto.getId()) : new Like();
        like.setDate(LocalDate.parse(likeCreateDto.getDate()));
        like.setComment(dtoService.findComment(likeCreateDto.getComment()));
        like.setUser(dtoService.findUser(likeCreateDto.getUser()));
        return like;

    }
}
