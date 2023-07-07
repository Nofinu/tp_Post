package com.example.tpvendredi_07_07.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto implements UserDto{
    private Integer id;
    private String username;
}
