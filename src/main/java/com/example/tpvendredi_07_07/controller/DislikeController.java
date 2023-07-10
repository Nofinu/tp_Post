package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Dislike.DislikeCreateDto;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.DislikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dislike")
public class DislikeController {
    @Autowired
    private DislikeService dislikeService;

    @PostMapping("/add")
    public ResponseEntity<Dislike> createDislike (@RequestBody @Valid DislikeCreateDto dislikeCreateDto) throws NotFounfException {
        return new ResponseEntity<>(dislikeService.create(dislikeCreateDto), HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<List<Dislike>> findByComment (@PathVariable Integer id) throws NotFounfException {
        return new ResponseEntity<>(dislikeService.findByComment(id),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDislike (@PathVariable Integer id) throws NotFounfException {
        if(dislikeService.delete(id)){
            return new ResponseEntity<>("dislike delete",HttpStatus.OK);
        }
        return new ResponseEntity<>("error during delete",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
