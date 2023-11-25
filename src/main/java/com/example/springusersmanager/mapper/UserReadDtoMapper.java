package com.example.springusersmanager.mapper;

import com.example.springusersmanager.dto.UserReadDto;
import com.example.springusersmanager.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserReadDtoMapper {

    public UserReadDto map(User user) {
        UserReadDto userReadDto = new UserReadDto();

        userReadDto.setUsername(user.getUsername());
        userReadDto.setFirstname(user.getFirstname());
        userReadDto.setLastname(user.getLastname());

        return userReadDto;
    }
}
