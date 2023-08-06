package com.dashboard.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document(collection = "Analytics")
public class AnalyticsEntity {

    private Date currentDate;
    private String diseaseDescription;
    private String city;
    private int count;
}
