package com.ats.controller;


import org.apache.log4j.Logger;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ats.appproperties.AppProperties;
import com.ats.entity.RegistrationEntity;
import com.ats.mailsender.MailSenderUtil;
import com.ats.pojo.Registration;
import com.ats.service.UserManagementService;


@Controller
public class RegisterController {
	final static Logger Log = Logger.getLogger(RegisterController.class);
	
	@Autowired
	@Qualifier("app")
	private AppProperties props;
	
	@Autowired
	private UserManagementService userService;
	

	@Autowired
	private MailSenderUtil mailSenderUtil; 
	
	
	@RequestMapping(value="/register")
	public String loginForm(Model model,@ModelAttribute("registerform") Registration registration) {
		Log.info("RegistrationForm Loaded");
	
		model.addAttribute("registerform", new Registration());
		return "registrationpage";
	}
	
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("registerform") Registration registration, Model model,RedirectAttributes redirectAttributes) throws Exception  {
		
		
	

		Integer regId=null;
		Log.info("RegistrationForm Loaded");
		RegistrationEntity regEntity=new RegistrationEntity();
		
		BeanUtils.copyProperties(registration, regEntity);
		
		
	
		model.addAttribute("regDtls", userService.save(regEntity));
		
		String successMsg=props.getProps().get("register-success");
		
		
		model.addAttribute("succMsg", successMsg);
		
	
		
		/* ============================================Used to send Mail from form========================================= */
		
		/*
		 * MimeMessage message = sender.createMimeMessage(); MimeMessageHelper helper =
		 * new MimeMessageHelper(message);
		 * 
		 * 
		 * try {
		 * 
		 * Log.info("=======mail method========="); helper.setFrom("Ats@gmail.com");
		 * helper.setTo(regEntity.getEmail());
		 * 
		 * helper.setSubject("ATS Account Registration");
		 * 
		 * 
		 * 
		 * helper.setText("Hello  " +regEntity.getFirstname()+
		 * " "+regEntity.getLastname()+
		 * 
		 * " Welcome To Ats Please click below link to unlock Your account Your Temperory Password is  "
		 * +regEntity.getPassword()+ " http://localhost:9090/ats/unlockScreen");
		 * 
		 * 
		 * } catch (MessagingException e) {
		 * 
		 * Log.warn("error"); e.printStackTrace(); return "Error while sending mail ..";
		 * } sender.send(message);
		 */
		
		if(regEntity!=null)
		{
		mailSenderUtil.sendMail(regEntity.getFirstname(),regEntity.getLastname(),regEntity.getPassword(),regEntity.getEmail()); 
		 regId = regEntity.getId();
		}
		
	        return "redirect:/register";
		
		
	}
	
	
	 

	
}
