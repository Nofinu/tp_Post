package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Comment.CommentDto;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDto commentDto) throws NotFounfException {
        return new ResponseEntity<>(commentService.create(commentDto), HttpStatus.OK);
    }
}
