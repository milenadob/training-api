package com.mak.trainingapi.controller;

import com.mak.trainingapi.model.User;
import com.mak.trainingapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{login}")
    public @ResponseBody User getUser(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @PostMapping
    public @ResponseBody void addUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
    }

}
