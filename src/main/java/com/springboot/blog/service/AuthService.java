package com.springboot.blog.service;

import com.springboot.blog.payload.JwtAuthResponse;
import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.SignUpDto;

public interface AuthService {

    public JwtAuthResponse authenticateUser(LoginDto loginDto);
    public void registerUser(SignUpDto signUpDto);
}
