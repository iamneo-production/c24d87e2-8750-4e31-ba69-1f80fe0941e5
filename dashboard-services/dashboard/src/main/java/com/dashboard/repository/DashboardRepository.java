package com.dashboard.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.dashboard.dto.AnalyticsEntity;

@Repository
public class DashboardRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<AnalyticsEntity> getDashboardView(){
        List<AnalyticsEntity>  entityList = mongoTemplate.findAll(AnalyticsEntity.class, "Analytics");

        return entityList;
    }

    public void publishDashboardView(){
        AnalyticsEntity analyticsEntity = new AnalyticsEntity(new Date(),"FEVER","Chennai",10);
        mongoTemplate.save(analyticsEntity , "Analytics");
        
    }
    
}
