package com.api.educationalsystem.controllers;

import com.api.educationalsystem.*;
import com.api.educationalsystem.models.LoginVO;
import com.api.educationalsystem.models.User;
import com.api.educationalsystem.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class UserController {
    private UserService userService;
    @PostMapping("/login")
    public LoginVO login(@RequestBody User loginDto) {
        return userService.login(loginDto);
    }
}
