package com.notification.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.notification.modeldto.Mail;
import com.notification.modeldto.NotificationData;

@Service
public class NotificationService {
	
	@Autowired
	MailService mailService;
	
	//	Send the otp through mail
	public boolean sendNotification(NotificationData data) {

		Mail mail = new Mail();
		mail.setMailFrom("aman123196@gmail.com");

			mail.setMailTo("amanarya@virtusa.com");
			mail.setMailSubject("Disease Spread");

			String content = "Hi Team,<br>"
					+ "This is to notify higher authorities that [[disease]] spread has increased to [[count]]<br>"
					+ "Please take necessary action.<br>"
					+ "Thank you,<br>"
					+ "Aman.";
			
			
			content = content.replace("[[disease]]",data.getDiseaseName());
			content = content.replace("[[count]]", Long.toString(data.getCount()));
			

			mail.setMailContent(content);

			mailService.sendEmail(mail);
			return true;
		}
}