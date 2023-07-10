package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Like.LikeCreateDto;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Like;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/add")
    public ResponseEntity<Like> createLike (@RequestBody LikeCreateDto likeCreateDto) throws NotFounfException {
        return new ResponseEntity<>(likeService.create(likeCreateDto), HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<List<Like>> findByComment (@PathVariable int id) throws NotFounfException {
        return new ResponseEntity<>(likeService.findByComment(id),HttpStatus.OK);
    }
}
