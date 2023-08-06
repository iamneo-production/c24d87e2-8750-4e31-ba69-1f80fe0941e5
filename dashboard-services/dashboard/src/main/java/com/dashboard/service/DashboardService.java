package com.dashboard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dashboard.dto.AnalyticsEntity;
import com.dashboard.dto.CentralData;
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

      public java.util.ArrayList<CentralData> publishDashboardView(){

       

        String url = analysis_service;

        ResponseEntity<Object> result = restTemplate.exchange(url,HttpMethod.GET,null,Object.class);

        java.util.ArrayList<CentralData> body = new ArrayList<>();

        System.out.println(" Results from Platform API validation ==>" +result.getBody());

        body = (java.util.ArrayList)result.getBody();

        System.out.println(" API response of /analytics :" + body);

        return body;

        // Iterator itr = body.iterator();
        // while(itr.hasNext()){
        //     CentralData centraldata = new CentralData();

        //     centraldata =(java.util.LinkedHashMap) itr.next();
        //     System.out.println ("centraldata :: " + centraldata);
        //     //  dashboardRepository.publishDashboardView(centraldata);
            
        // }
        //  dashboardRepository.publishDashboardView(body);
    }


     public AnalyticsEntity AnalyticsFallbackMethod() {
        AnalyticsEntity analyticsEntity = new AnalyticsEntity(new Date(),"MALARIA","Chennai",10);
              
        return analyticsEntity;
    }
    
}
