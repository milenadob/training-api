package com.mak.trainingapi.controller;

import com.mak.trainingapi.dto.AuthRequestDto;
import com.mak.trainingapi.dto.UserViewDto;
import com.mak.trainingapi.mapper.UserViewMapper;
import com.mak.trainingapi.model.User;

import com.mak.trainingapi.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<UserViewDto> login(@RequestBody @Valid AuthRequestDto requestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.username(), requestDto.password()));
        String token = authService.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS , HttpHeaders.AUTHORIZATION)
                .body(UserViewMapper.INSTANCE.userToUserView(user));
    }
}
