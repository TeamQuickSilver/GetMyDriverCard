package com.quicksilver.web.controllers;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import com.quicksilver.web.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class LoginController {
    private final UserDetailsService userService;
    private final ApplicationService applicationService;

    @Autowired
    public LoginController(UserDetailsService userService, ApplicationService applicationService) {
        this.userService = userService;
        this.applicationService = applicationService;
    }

    @ModelAttribute
    public List<Application> modelObject() {
        return applicationService.getAllByStatus(ApplicationStatus.NEW);
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
//        model.addAttribute("view", "redirect:/applications");

        return "login";
    }
}
