package com.example.tpvendredi_07_07.service;

import com.example.tpvendredi_07_07.dto.Dislike.DislikeCreateDto;
import com.example.tpvendredi_07_07.dto.Like.LikeCreateDto;
import com.example.tpvendredi_07_07.dto.Like.LikeDtoToLike;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.entity.Like;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private LikeDtoToLike likeDtoToLike;

    public Like create (LikeCreateDto likeCreateDto) throws NotFounfException {
        Like like = likeDtoToLike.convert(likeCreateDto);
        return likeRepository.save(like);
    }


}
