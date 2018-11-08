package com.quicksilver.web.controllers;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import com.quicksilver.web.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@PreAuthorize("isAuthenticated()")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/applications")
    public ModelAndView getAllApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @GetMapping("/applications/{id}")
    public ModelAndView getApplicationById(@PathVariable Long id) {
        Application applicationDetails = applicationService.getById(id);

        return new ModelAndView("details.html", "applicationDetails", applicationDetails);
    }

    @RequestMapping("/applications/approve/{id}")
    public ModelAndView approveApplication(@PathVariable Long id) {
        Application applicationDetails = applicationService.getById(id);
        applicationDetails.setStatus(ApplicationStatus.APPROVED);
        applicationService.save(applicationDetails);

        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);
        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/reject/{id}")
    public ModelAndView rejectApplication(@PathVariable Long id) {
        Application applicationDetails = applicationService.getById(id);
        applicationDetails.setStatus(ApplicationStatus.REJECTED);
        applicationService.save(applicationDetails);

        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);
        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/inprogress/{id}")
    public ModelAndView setInProgressStatus(@PathVariable Long id) {
        Application applicationDetails = applicationService.getById(id);
        applicationDetails.setStatus(ApplicationStatus.INPROGRESS);
        applicationService.save(applicationDetails);

        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);
        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/complete/{id}")
    public ModelAndView setCompletedStatus(@PathVariable Long id) {
        Application applicationDetails = applicationService.getById(id);
        applicationDetails.setStatus(ApplicationStatus.COMPLETED);
        applicationService.save(applicationDetails);

        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);
        return new ModelAndView("application.html", "applicationList", applicationList);
    }
}
