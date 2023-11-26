package com.example.springusersmanager.service;

import com.example.springusersmanager.dto.UserReadDto;
import com.example.springusersmanager.entity.User;
import com.example.springusersmanager.mapper.UserCreateEditDtoMapper;
import com.example.springusersmanager.mapper.UserReadDtoMapper;
import com.example.springusersmanager.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.ManyToOne;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserReadDtoMapper userReadDtoMapper;
    @Mock
    private UserCreateEditDtoMapper userCreateEditDtoMapper;

    @InjectMocks
    private UserService userService;

    @Test
    void findAll() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        when(userReadDtoMapper.map(any())).thenReturn(new UserReadDto());

        List<UserReadDto> actulaList = userService.findAll();

        Assertions.assertEquals(2, actulaList.size());
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}