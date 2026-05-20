package com.example.pertemuan11.controller;

import com.example.pertemuan11.model.User;
import com.example.pertemuan11.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AuthService authService;

    // Constructor manual yang aman dari error Lombok
    public HomeController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        User user = authService.getLoggedInUser();
        model.addAttribute("user", user);
        model.addAttribute("profile", user.getProfile());
        return "home";
    }
}