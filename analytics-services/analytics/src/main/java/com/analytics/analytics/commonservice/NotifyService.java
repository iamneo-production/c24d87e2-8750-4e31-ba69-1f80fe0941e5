package com.analytics.analytics.commonservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.analytics.analytics.modeldto.NotificationData;

@FeignClient(name = "notificationservice")
public interface NotifyService {
	
	@GetMapping("/notificationController/notify")
	public boolean notification(NotificationData data);

}