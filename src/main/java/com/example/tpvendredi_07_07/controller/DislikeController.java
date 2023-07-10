package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Dislike.DislikeCreateDto;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.DislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dislike")
public class DislikeController {
    @Autowired
    private DislikeService dislikeService;

    @PostMapping("/add")
    public ResponseEntity<Dislike> createDislike (@RequestBody DislikeCreateDto dislikeCreateDto) throws NotFounfException {
        return new ResponseEntity<>(dislikeService.create(dislikeCreateDto), HttpStatus.OK);
    }
}
