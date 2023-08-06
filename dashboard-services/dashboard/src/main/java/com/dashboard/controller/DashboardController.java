package com.dashboard.controller;


import com.dashboard.dto.AnalyticsEntity;
import com.dashboard.dto.ResponseMessage;
import com.dashboard.service.DashboardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;
    

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

    @GetMapping(value= "/view")
    public ResponseEntity<Object> getDashboardView(){

        System.out.println(" Test print in dashboard view method in dashboard service");

        List<AnalyticsEntity> dashboardList = dashboardService.getDashboardView();

        ResponseMessage message = new ResponseMessage();
        message.setResponseData(dashboardList);

         return new ResponseEntity<>(
            message, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PostMapping(value="/publish")
    public ResponseEntity<Object> publishDashboardView(){


        // read analytics get api and group the data.

        dashboardService.publishDashboardView();

        ResponseMessage message = new ResponseMessage();
        message.setResponseData("Success");

         return new ResponseEntity<>(
            message, new HttpHeaders(), HttpStatus.CREATED);
    }
 
}