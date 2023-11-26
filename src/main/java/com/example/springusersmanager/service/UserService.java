package com.example.springusersmanager.service;

import com.example.springusersmanager.dto.UserCreateEditDto;
import com.example.springusersmanager.dto.UserReadDto;
import com.example.springusersmanager.entity.User;
import com.example.springusersmanager.mapper.UserCreateEditDtoMapper;
import com.example.springusersmanager.mapper.UserReadDtoMapper;
import com.example.springusersmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserReadDtoMapper userReadDtoMapper;
    private final UserCreateEditDtoMapper userCreateEditDtoMapper;

    public UserService(UserRepository userRepository, UserReadDtoMapper userReadDtoMapper, UserCreateEditDtoMapper userCreateEditDtoMapper) {
        this.userRepository = userRepository;
        this.userReadDtoMapper = userReadDtoMapper;
        this.userCreateEditDtoMapper = userCreateEditDtoMapper;
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadDtoMapper::map)
                .collect(Collectors.toList());
    }

    public UserReadDto findById(Long id) {
        return userRepository.findById(id)
                .map(userReadDtoMapper::map)
                .orElseThrow(RuntimeException::new);
    }

    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditDtoMapper::map)
                .map(userRepository::save)
                .map(userReadDtoMapper::map)
                .orElseThrow(RuntimeException::new);
    }

    public UserReadDto update(Long id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(user -> userCreateEditDtoMapper.mapWithEdit(user, userDto))
                .map(userRepository::save)
                .map(userReadDtoMapper::map)
                .orElseThrow(RuntimeException::new);
    }

    public boolean delete(Long id) {
        Optional<User> maybeUser = userRepository.findById(id);

        if (maybeUser.isPresent()) {
            userRepository.delete(maybeUser.get());
            return true;
        }

        return false;
    }
}
