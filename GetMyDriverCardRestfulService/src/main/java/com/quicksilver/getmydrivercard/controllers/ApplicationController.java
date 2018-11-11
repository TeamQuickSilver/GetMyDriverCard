package com.quicksilver.getmydrivercard.controllers;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.services.ApplicationService;
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

    @GetMapping("/user/{email}")
    public List<Application> getAllByUserOrderById(@PathVariable String email) {
        return applicationService.getAllByUserEmail(email);
    }

//    @GetMapping("/request/{status}")
//    public List<Application> getAllByStatus(@PathVariable String status) {
//        return applicationService.getAllByStatus(Enum.valueOf(ApplicationStatus.class, status));
//    }
//
//    @GetMapping("/name")
//    public List<Application> getAllOrderByPersonName() {
//        return applicationService.getAllOrderByPersonName();
//    }
//
//    @GetMapping("/filter/{date}")
//    public List<Application> getAllOrderByDateOfSubmission(@PathVariable Date date) {
//        return applicationService.getAllOrderByDateOfSubmission(date);
//    }

    @GetMapping("/{id}")
    public List<Application> getById(@PathVariable Long id) {
        return applicationService.getByIdentityNumber(id);
    }

    @PostMapping
    public Application save(@RequestBody Application application) {
        return applicationService.save(application);
    }
}
