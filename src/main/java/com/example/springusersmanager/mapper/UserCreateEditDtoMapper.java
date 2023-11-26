package com.example.springusersmanager.mapper;

import com.example.springusersmanager.dto.UserCreateEditDto;
import com.example.springusersmanager.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateEditDtoMapper {

    public User map(UserCreateEditDto userDto) {
        User user = new User();

        copy(userDto, user);

        return user;
    }

    public User mapWithEdit(User user, UserCreateEditDto userDto) {
        copy(userDto, user);

        return user;
    }

    private void copy(UserCreateEditDto userDto, User user) {
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setBirthDate(userDto.getBirthDate());
    }
}
