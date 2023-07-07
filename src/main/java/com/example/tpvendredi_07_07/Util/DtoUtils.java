package com.example.tpvendredi_07_07.Util;

import com.example.tpvendredi_07_07.dto.User.UserDto;
import com.example.tpvendredi_07_07.entity.User;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoUtils {
    public UserDto UserconvertToDto(User user, UserDto userDto) {
        return new ModelMapper().map(user, userDto.getClass());
    }

    public User UserconvertToEntity(User user, UserDto userDto) {
        return new ModelMapper().map(userDto, user.getClass());
    }

}
