package com.example.springusersmanager.controller;

import com.example.springusersmanager.dto.UserCreateEditDto;
import com.example.springusersmanager.dto.UserReadDto;
import com.example.springusersmanager.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CRUD - операции
 * С - create
 * R - read
 * U - update
 * D - delete
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserReadDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserReadDto create(UserCreateEditDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable("id") Long id, UserCreateEditDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
