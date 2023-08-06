package com.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.service.NotificationService;
import com.notification.modeldto.NotificationData;

@RestController
@RequestMapping("/notificationController")
public class NotificationController {
    

    @Autowired
	NotificationService notificationService;
	
	@PostMapping("/notify")
	public boolean notification(@RequestBody NotificationData data) {
		return notificationService.sendNotification(data);
	}
}
