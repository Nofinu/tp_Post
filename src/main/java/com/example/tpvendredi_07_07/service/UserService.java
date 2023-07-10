package com.example.tpvendredi_07_07.service;

import com.example.tpvendredi_07_07.Util.DtoUtils;
import com.example.tpvendredi_07_07.dto.User.UserCreateDto;
import com.example.tpvendredi_07_07.dto.User.UserDto;
import com.example.tpvendredi_07_07.dto.User.UserReadDto;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Like;
import com.example.tpvendredi_07_07.entity.User;
import com.example.tpvendredi_07_07.exception.AlreadyExistExeption;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DtoUtils dtoUtils;

    public UserDto create(UserCreateDto userCreateDto) throws NotFounfException, AlreadyExistExeption {
        if(userRepository.findByUsername(userCreateDto.getUsername()) == null){
            User user = userCreateDto.getId() != null ? findById(userCreateDto.getId()) : new User();
            user = userRepository.save(dtoUtils.UserconvertToEntity(user,userCreateDto));
            return dtoUtils.UserconvertToDto(user,new UserReadDto());
        }
    throw new AlreadyExistExeption();
    }

    public User findById(int id) throws NotFounfException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new NotFounfException();
    }
}
