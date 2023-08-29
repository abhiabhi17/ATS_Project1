package com.ats.mailsender;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ats.AppConstants.AppConstants;
import com.ats.AppConstants.MailConstants;
import com.ats.appproperties.AppProperties;
import com.ats.exceptns.MailSendingIssueException;



@Component
public class MailSenderUtil {
	
	final static Logger Log = Logger.getLogger(MailSenderUtil.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Autowired
	@Qualifier("app")
	private AppProperties props;

	//==================================USER MAIL SENDER========================================================================//
	
	
	public boolean sendMail(String firstname, String lastname, String password, String email) throws IOException, MailSendingIssueException  {
	
		boolean flag=false;
		ClassPathResource fileReader = new ClassPathResource(MailConstants.EMAIL_TEMPLATE_FILE);
		File file = fileReader.getFile();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String template = "";
			if (bufferedReader != null) {
				while (bufferedReader.ready()) {
					template = template + bufferedReader.readLine();
				}
				if (template != null && !template.equals("")) {
					template = template.replace(MailConstants.FNAME_PHOLDER, firstname);
					template = template.replace(MailConstants.LNAME_PHOLDER, lastname);
					template = template.replace(MailConstants.TEMP_PWD_PHOLDER, password);
					template = template.replace(MailConstants.EMAIL_PHOLDER, email);
				}
				Log.info(template);
			}
			try {
				MimeMessage message=mailSender.createMimeMessage();
				MimeMessageHelper helper=new MimeMessageHelper(message, flag);
				helper.setTo(email);
				helper.setSubject(props.getProps().get(AppConstants.PROP_KEY_FOR_MAIL_SUBJECT));
				helper.setText(template, true);
				mailSender.send(message);
				flag=true;
			}catch (Exception e) {
				
				throw new MailSendingIssueException(MailConstants.ERROR_MSG);
			}
		}
		return flag;
		
		
	}

	
	
	
	
	
	
	
	
	//==================================AGENCY MAIL SENDER========================================================================//
	
/*	
	public boolean sendMail(String agencyname, String password, String email) throws FileNotFoundException, IOException, MailSendingIssueException {
		
		boolean flag=false;
		ClassPathResource fileReader = new ClassPathResource(MailConstants.AGENCY_EMAIL_TEMPLATE_FILE);
		File file = fileReader.getFile();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String template = "";
			if (bufferedReader != null) {
				while (bufferedReader.ready()) {
					template = template + bufferedReader.readLine();
				}
				if (template != null && !template.equals("")) {
					template = template.replace(MailConstants.AGENCY_PLCHLDER, agencyname);
				
					template = template.replace(MailConstants.AGENCY_TEMP_PWD_PHOLDER, password);
					template = template.replace(MailConstants.AGENCY_EMAIL_PHOLDER, email);
				}
				Log.info(template);
			}
			try {
				MimeMessage message=mailSender.createMimeMessage();
				MimeMessageHelper helper=new MimeMessageHelper(message, flag);
				helper.setTo(email);
				helper.setSubject(props.getProps().get(AppConstants.PROP_KEY_FOR_AGENCY_MAIL_SUBJECT));
				helper.setText(template, true);
				mailSender.send(message);
				flag=true;
			}catch (Exception e) {
				
				throw new MailSendingIssueException(MailConstants.AGENCY_ERROR_MSG);
			}
		}
		return flag;
		
		*/
		
	}

	


