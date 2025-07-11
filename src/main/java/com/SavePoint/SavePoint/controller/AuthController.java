package com.SavePoint.SavePoint.controller;

import com.SavePoint.SavePoint.configs.TokenService;
import com.SavePoint.SavePoint.controller.request.LoginRequest;
import com.SavePoint.SavePoint.controller.request.UserRequest;
import com.SavePoint.SavePoint.controller.response.LoginResponse;
import com.SavePoint.SavePoint.controller.response.UserResponse;
import com.SavePoint.SavePoint.entity.User;
import com.SavePoint.SavePoint.exception.UsernameOrPasswordInvalidException;
import com.SavePoint.SavePoint.mapper.UserMapper;
import com.SavePoint.SavePoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savepoint/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User savedUser = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){

        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);

            User user = (User) authentication.getPrincipal();

            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        }catch (BadCredentialsException ex){
             throw new UsernameOrPasswordInvalidException("Usuario ou senha invalido");
        }
    }
}
