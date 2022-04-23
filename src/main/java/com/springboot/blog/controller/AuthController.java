package com.springboot.blog.controller;

import com.springboot.blog.payload.JwtAuthResponse;
import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.SignUpDto;
import com.springboot.blog.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Api(value = "Auth controller exposes signin and signup REST APIs")
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

   private final AuthService authService;

   @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "Rest API to login user to Blog app")
    @PostMapping("signin")
    public ResponseEntity<JwtAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(authService.authenticateUser(loginDto), HttpStatus.OK);

    }

    @ApiOperation("Rest API to register user to Blog app")
    @PostMapping("signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {
        authService.registerUser(signUpDto);
        return new ResponseEntity<>("User Registered successfully", HttpStatus.CREATED);

    }


}
