package com.quicksilver.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private final UserDetailsService userService;

    @Autowired
    public LoginController(UserDetailsService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login(Model model) {
        model.addAttribute("view", "index");

        return "login";
    }
}
