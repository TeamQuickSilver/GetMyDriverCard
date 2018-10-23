package com.quicksilver.getmydrivercard.controllers;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.services.ApplicationService;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllByUsernameOrderById(@RequestBody User user) {
        return applicationService.getAllByUserOrderById(user);
    }

    @GetMapping("/status")
    public List<Application> getAllByStatus(@RequestBody ApplicationStatus status) {
        return applicationService.getAllByStatus(status);
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable Long id) {
        return applicationService.getById(id);
    }

}
