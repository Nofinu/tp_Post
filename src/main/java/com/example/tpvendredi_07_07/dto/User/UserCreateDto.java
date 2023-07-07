package com.example.tpvendredi_07_07.dto.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements UserDto{
    private Integer id;

    @NotNull(message = "Invalid UserName : Username null")
    @NotEmpty(message = "Invalid UserName : Username empty")
    private String username;
    @NotNull(message = "Invalid UserName : Username null")
    @NotEmpty(message = "Invalid UserName : Username empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{1,8}$",message = "Invalid Password, password must be contain one capital letter one number et one special character")
    private String password;
}
