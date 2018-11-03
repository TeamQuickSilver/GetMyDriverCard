package com.quicksilver.web.controllers;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import com.quicksilver.web.models.User;
import com.quicksilver.web.services.ApplicationService;
import com.quicksilver.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/login")
//    public String loginGet() {
//        return "index";
//    }

//    @PostMapping("/login")
//    public ModelAndView loginPost(@RequestBody User user) {
//        boolean isLoginSucceeded = userService.login(user);
//        List<Application> applications = applicationService.getAllByStatus(ApplicationStatus.NEW);
//
//        if(isLoginSucceeded) {
//            ModelAndView userModel = new ModelAndView("applications");
//            for (Application application : applications) {
//                userModel.addObject(application);
//            }
//
//            return userModel;
//        } else {
//            return new ModelAndView("index");
//        }
//    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login(Model model) {
        model.addAttribute("view", "index");

        return "login";
    }
}
