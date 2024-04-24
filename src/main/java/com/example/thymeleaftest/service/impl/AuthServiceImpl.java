package com.example.thymeleaftest.service.impl;


import com.example.thymeleaftest.model.Role;
import com.example.thymeleaftest.model.User;
import com.example.thymeleaftest.model.request.RegisterDto;
import com.example.thymeleaftest.repository.UserRepository;
import com.example.thymeleaftest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void register(RegisterDto registerDto) {
    User user = new User();
    user.setUsername(registerDto.getUsername());
    user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
    user.setEmail(registerDto.getEmail());
    user.setRole(Role.ADMIN);
    userRepository.save(user);
  }

}
