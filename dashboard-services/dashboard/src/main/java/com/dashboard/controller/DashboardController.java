package com.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/dashboard")
public class DashboardController {
    

    @GetMapping(value = "/welcome")
    public ResponseEntity<Object> getDashboardWelcome() {

        System.out.println(" Test print in dashboard welcome service - get mapping");
        return new ResponseEntity<>(
            "Success", new HttpHeaders(), HttpStatus.CREATED);
    }

    @PostMapping(value = "/testPost")
    public ResponseEntity<Object> postDashboardWelcome() {

        System.out.println(" Test print in test post dashboard service");
        return new ResponseEntity<>(
            "Success", new HttpHeaders(), HttpStatus.CREATED);
    }
}