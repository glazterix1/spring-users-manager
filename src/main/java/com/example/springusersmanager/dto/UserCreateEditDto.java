package com.example.springusersmanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateEditDto {

    private String username;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
}
