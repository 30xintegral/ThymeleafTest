package com.example.thymeleaftest.service;


import com.example.thymeleaftest.model.request.RegisterDto;

public interface AuthService {

  void register(RegisterDto registerDto);

}
