package com.example.tpvendredi_07_07.controller;

import com.example.tpvendredi_07_07.dto.Post.PostDto;
import com.example.tpvendredi_07_07.dto.User.UserCreateDto;
import com.example.tpvendredi_07_07.dto.User.UserDto;
import com.example.tpvendredi_07_07.dto.User.UserReadDto;
import com.example.tpvendredi_07_07.entity.Post;
import com.example.tpvendredi_07_07.exception.AlreadyExistExeption;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.PostService;
import com.example.tpvendredi_07_07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser (@RequestBody UserCreateDto userCreateDto) throws NotFounfException, AlreadyExistExeption {
        return new ResponseEntity<>(userService.create(userCreateDto), HttpStatus.OK);
    }
}
