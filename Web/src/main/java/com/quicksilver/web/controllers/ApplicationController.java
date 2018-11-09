package com.quicksilver.web.controllers;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import com.quicksilver.web.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@PreAuthorize("isAuthenticated()")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping("/applications/new")
    public ModelAndView getNewApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.NEW);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/approved")
    public ModelAndView getApprovedApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.APPROVED);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }


    @RequestMapping("/applications/rejected")
    public ModelAndView getRejectedApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.REJECTED);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/inprogress")
    public ModelAndView getInProgressApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.INPROGRESS);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/completed")
    public ModelAndView getCompletedApplications() {
        List<Application> applicationList = applicationService.getAllByStatus(ApplicationStatus.COMPLETED);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/date/{dateStr}")
    public ModelAndView getAllByDateOfSubmission(@PathVariable String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Application> applicationList = applicationService.getAllOrderByDateOfSubmission(date);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/name/{name}")
    public ModelAndView getAllByName(@PathVariable String name) {
        List<Application> applicationList = applicationService.getAllOrderByPersonName(name);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/id/{id}")
    public ModelAndView getById(@PathVariable Long id) {
        List<Application> applicationList = applicationService.getByIdentityNumber(id);

        return new ModelAndView("application.html", "applicationList", applicationList);
    }

    @RequestMapping("/applications/{id}")
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
