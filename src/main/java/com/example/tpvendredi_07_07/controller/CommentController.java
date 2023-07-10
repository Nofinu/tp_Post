package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Comment.CommentDto;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.CommentService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDto commentDto) throws NotFounfException {
        return new ResponseEntity<>(commentService.create(commentDto), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<Comment>> findByPost (@PathVariable Integer id) throws NotFounfException {
        return new ResponseEntity<>(commentService.findByPost(id),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment (@PathVariable Integer id) throws NotFounfException {
        if(commentService.delete(id)){
            return new ResponseEntity<>("comment delete",HttpStatus.OK);
        }
        return new ResponseEntity<>("error during delete",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
