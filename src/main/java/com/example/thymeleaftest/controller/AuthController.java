package com.example.thymeleaftest.controller;

import com.example.thymeleaftest.model.User;
import com.example.thymeleaftest.model.request.LoginDto;
import com.example.thymeleaftest.model.request.RegisterDto;
import com.example.thymeleaftest.repository.UserRepository;
import com.example.thymeleaftest.security.JwtTokenProvider;
import com.example.thymeleaftest.service.AuthService;
import com.example.thymeleaftest.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final AuthService service;

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;

    private final JwtTokenProvider jwtTokenProvider;

    @Value("${jwtSecret}")
    String jwtSecret;

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register_page";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        LoginDto user = new LoginDto();
        model.addAttribute("user", user);
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDto user){

//        if (userRepository.exists(user.getEmail())){
//            model.addAttribute("userExists", "");
//            return "redirect:/login";
//        }
        service.register(user);
        return "redirect:/auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginRequest, Model model, HttpServletResponse response){
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword(),
                                userDetails.getAuthorities()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        response.setHeader("Authorization", jwtTokenProvider.generateToken(authentication));
        return "redirect:/home";


        //users tableda yaratdigimiz role columnu deqiqlesdirmek lazimdir
        //burani deqiqlesdirmek lazimdir
    }

}
