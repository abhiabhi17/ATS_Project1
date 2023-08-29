package com.ats.controller;

import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ats.AppConstants.AppConstants;
import com.ats.appproperties.AppProperties;

import com.ats.pojo.Login;
import com.ats.pojo.Registration;
import com.ats.service.UserManagementService;


@Controller
public class LoginController {

	@Autowired
	@Qualifier("app")
	private AppProperties props;
	
	@Autowired
	private UserManagementService userService;

	final static Logger Log = Logger.getLogger(LoginController.class);

	@RequestMapping(value=AppConstants.Login_URL)
	public String loginForm(Model model) {
		
	
		model.addAttribute("login", new Login());
		
		Log.info(" Login Form Loaded");
		return AppConstants.LOGIN_PAGE;
	}
	
	
	@RequestMapping(value = "/dashBoard", method = RequestMethod.POST)
	public String userdashboard(@ModelAttribute("login") Registration registration,Model model,HttpServletRequest request,RedirectAttributes redirectAttributes)
		{
		
		Log.info("==== userdashboard Form Loaded======");
		
		
	
		if(registration!=null && registration.getEmail()!=null) 
		{
		Registration reg=userService.isUserExist(registration.getEmail(),registration.getPassword());
		
		if(reg.getId()!=null) 
		{
			if(reg.getLockstatus().equals("locked"))
			{
				redirectAttributes.addFlashAttribute(AppConstants.MODE_KEY_FOR_MSG, props.getProps().get(AppConstants.PROP_KEY_FOR_UN_LOCK_MSG));
				return "errorpage";
				
			}
			
			else
			{
				if(reg.getRole().equals(AppConstants.KEY_FOR_USER_ROLL_NAME)) 
				{
					redirectAttributes.addFlashAttribute(AppConstants.MODE_KEY_FOR_MSG, props.getProps().get(AppConstants.PROP_KEY_FOR_BOARD_MSG));
				return AppConstants.LOG_VIEW_FOR_USER_DASHBOARD;
				}
				
				if(reg.getRole().equals("admin"))
					{
					return AppConstants.LOG_VIEW_FOR_ADMIN_DASHBOARD;
					}
			}	
		}
		else 
		{
			redirectAttributes.addFlashAttribute(AppConstants.MODE_KEY_FOR_MSG, props.getProps().get(AppConstants.PROP_KEY_FOR_SIGN_FAILED_MSG));
			return "errorpage";

		}
	}
		
		
		/*
		 * RegistrationEntity regEntity = new RegistrationEntity();
		 * 
		 * BeanUtils.copyProperties(registration, regEntity);
		 * 
		 * String uname= request.getParameter("username"); String pwd=
		 * request.getParameter("password");
		 * 
		 * System.out.println(uname); System.out.println(pwd);
		 * System.out.println(regEntity.getEmail());
		 */
		 
		  return AppConstants.USR_DSBOARD;
		}	   
		
	}


