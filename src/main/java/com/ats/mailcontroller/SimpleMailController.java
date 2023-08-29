package com.ats.mailcontroller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.entity.RegistrationEntity;

@RestController
public class SimpleMailController {
    @Autowired
    private JavaMailSender sender;

	/* @RequestMapping("/sendMail") */
    public String sendMail(RegistrationEntity regEntity) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
        	helper.setFrom("Ats@gmail.com");
            helper.setTo("abhiabhishek.pavadi@gmail.com");
            helper.setText("http://localhost:9090/ats/login");
            helper.setSubject("Please Click this Below Link To Activate Your Account");
           
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
}