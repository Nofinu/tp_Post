package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Post.PostDto;
import com.example.tpvendredi_07_07.entity.Post;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<List<Post>> findAll (){
        return new ResponseEntity<>(postService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> createPost (@RequestBody @Valid PostDto postDto) throws NotFounfException {
        return new ResponseEntity<>(postService.create(postDto), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment (@PathVariable Integer id) throws NotFounfException {
        if(postService.delete(id)){
            return new ResponseEntity<>("Post delete",HttpStatus.OK);
        }
        return new ResponseEntity<>("error during delete",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
