package com.dashboard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dashboard.dto.AnalyticsEntity;
import com.dashboard.repository.DashboardRepository;
import org.springframework.web.client.RestTemplate;


@Service
public class DashboardService {

    @Autowired
    DashboardRepository dashboardRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${api_gateway_analysis_service}")
    String  analysis_service;

    public List<AnalyticsEntity> getDashboardView(){
        List<AnalyticsEntity> analyticsEntity = new ArrayList<>();

        analyticsEntity = dashboardRepository.getDashboardView();

        return analyticsEntity;
    }

      public void publishDashboardView(){

        dashboardRepository.publishDashboardView();

        String url = analysis_service;

        ResponseEntity<Object> result = restTemplate.exchange(url,HttpMethod.GET,null,Object.class);

        java.util.LinkedHashMap<String, Object> body = new LinkedHashMap<>();

        System.out.println(" Results from Platform API validation ==>" +result.getBody());

        body = (LinkedHashMap)result.getBody();

        System.out.println(" API response of /analytics :" + body);
    }


     public AnalyticsEntity AnalyticsFallbackMethod() {
        AnalyticsEntity analyticsEntity = new AnalyticsEntity(new Date(),"MALARIA","Chennai",10);
              
        return analyticsEntity;
    }
    
}
