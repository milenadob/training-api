package com.mak.trainingapi.controller;

import com.mak.trainingapi.dto.UserRegisterDto;
import com.mak.trainingapi.dto.UserUpdateDto;
import com.mak.trainingapi.dto.UserViewDto;
import com.mak.trainingapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public @ResponseBody UserViewDto create(@Valid @RequestBody UserRegisterDto registerDto) {
        return userService.createUser(registerDto);
    }

    @PutMapping("{username}")
    public UserViewDto update(@PathVariable String username, @RequestBody @Valid UserUpdateDto userUpdateDto){
        return userService.updateUser(username, userUpdateDto);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable String username){
        userService.deleteUser(username);
    }

    @GetMapping("{username}")
    public UserViewDto get(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
}
