package com.example.springusersmanager.service;

import com.example.springusersmanager.dto.UserReadDto;
import com.example.springusersmanager.mapper.UserReadDtoMapper;
import com.example.springusersmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserReadDtoMapper userReadDtoMapper;

    public UserService(UserRepository userRepository, UserReadDtoMapper userReadDtoMapper) {
        this.userRepository = userRepository;
        this.userReadDtoMapper = userReadDtoMapper;
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadDtoMapper::map)
                .collect(Collectors.toList());
    }
}

