package com.example.springusersmanager.controller;

import com.example.springusersmanager.dto.UserReadDto;
import com.example.springusersmanager.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
