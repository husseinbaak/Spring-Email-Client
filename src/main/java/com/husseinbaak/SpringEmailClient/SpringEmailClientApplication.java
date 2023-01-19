package com.husseinbaak.SpringEmailClient;

import com.husseinbaak.SpringEmailClient.email.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {
	@Autowired
	private EmailSendService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)

	public void triggerMail() throws MessagingException {
		service.sendSimpleEmail("sy.hussein0988@gmail.com",
				"This is the email bode ....",
				"This is the email subject");

				service.sendEmailWithAttachment("sy.hussein0988@gmail.com",
						"Hello Hussein ",
						"This is your photo",
						"C:\\Users\\HUSSEIN\\Desktop\\w9781118140673a3-1.jpg");

	}

}
