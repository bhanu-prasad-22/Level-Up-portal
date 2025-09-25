package com.levelup.levelup_portal.controller;

import com.levelup.levelup_portal.dto.UserDto;
import com.levelup.levelup_portal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    // 1️⃣ Home Page
    @GetMapping("/")
    public String home() {
        return "home"; // renders home.html
    }

    // 2️⃣ Register Form
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register"; // renders register.html
    }

    // 3️⃣ Handle Registration
    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute UserDto userDto, Model model) {
        try {
            userDto.setRole("ROLE_USER");
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword())); // encode password
            userService.createUser(userDto);
            return "redirect:/auth/login"; // redirect to login page
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }

    // 4️⃣ Login Form
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // renders login.html
    }

    // 5️⃣ Handle Login
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email,
                              @RequestParam String password,
                              Model model) {
        try {
            UserDto user = userService.getUserByEmail(email);
            if (user != null && passwordEncoder.matches(password, user.getPassword())) {
                model.addAttribute("user", user);
                return "dashboard"; // renders dashboard.html
            } else {
                model.addAttribute("error", "Invalid credentials!");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Login failed: " + e.getMessage());
            return "login";
        }
    }

    // 6️⃣ Logout
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/auth/"; // back to home
    }
}