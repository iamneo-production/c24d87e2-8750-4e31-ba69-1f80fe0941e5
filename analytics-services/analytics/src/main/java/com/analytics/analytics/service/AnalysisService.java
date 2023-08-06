package com.analytics.analytics.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analytics.analytics.modeldto.NotificationData;
import com.analytics.analytics.modeldto.ResponseDto;
import com.analytics.analytics.commonservice.AnalysisCount;
import com.analytics.analytics.commonservice.NotifyService;

@Service
public class AnalysisService {

	
	@Autowired
	AnalysisCount analysisCount;
	
	@Autowired
	NotifyService notifyService;
	
	
	public String getAnalysis() {
		String response;
		int flag = 0;
		ResponseDto result = analysisCount.analysisCounts();
		NotificationData data = new NotificationData();
		for(Map.Entry<String, Long> i : result.getDiseaseName().entrySet()) {
			data.setDiseaseName(i.getKey());
			data.setCount(i.getValue());
			notifyService.notification(data);
			flag = 1;
		}
		if(flag==0) {
			response = "Dieases are not spreading";
		}else {
			response = "notification sent successfully";
		}
		return response;
	}

}