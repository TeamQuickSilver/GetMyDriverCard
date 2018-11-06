package com.quicksilver.web.controllers;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import com.quicksilver.web.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/applications")
@PreAuthorize("isAuthenticated()")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ModelAndView getAllApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @GetMapping("/{id}")
    public ModelAndView getApplicationById(@PathVariable Long id) {
        Application applicationDetails = applicationService.getById(id);

        return new ModelAndView("details.html", "applicationDetails", applicationDetails);
    }
}
