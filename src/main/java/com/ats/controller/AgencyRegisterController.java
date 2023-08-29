package com.ats.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ats.appproperties.AppProperties;
import com.ats.entity.RegistrationEntity;
import com.ats.mailsender.MailSenderUtil;
import com.ats.pojo.Registration;
import com.ats.service.AgencyManagementService;






@Controller
 
public class AgencyRegisterController {
	
	final static Logger Log = Logger.getLogger(AgencyRegisterController.class);
private static RegistrationEntity regi;
	
	@Autowired
	@Qualifier("app")
	private AppProperties props;
	
	@Autowired
	private MailSenderUtil mailSenderUtil; 
	
	@Autowired
	private AgencyManagementService agencyService;

	
	@RequestMapping(value="/agencyRegister")
	public String loginForm(Model model,@ModelAttribute("registerform") RegistrationEntity registration) {
		Log.info("RegistrationForm Loaded");
	
		model.addAttribute("registerform", new RegistrationEntity());
		return "agencyRegistrationPage";
	}
	
	
	@RequestMapping(value = "/registerAgency", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("registerform") RegistrationEntity registration,
			BindingResult result,
			Model model,RedirectAttributes 
			redirectAttributes) throws Exception  {
		
	
		Integer regId=null;
		Log.info("Agency RegistrationForm Loaded");
		RegistrationEntity agencyregEntity=new RegistrationEntity();
		
		BeanUtils.copyProperties(registration, agencyregEntity);
		
		model.addAttribute("regDtls", agencyService.save(agencyregEntity));
		
		
		regi=agencyregEntity;
		
		String successMsg=props.getProps().get("register-success");
		
		
		model.addAttribute("succMsg", successMsg);
		
		if(agencyregEntity!=null)
		{
			mailSenderUtil.sendMail(agencyregEntity.getFirstname(),agencyregEntity.getLastname(),agencyregEntity.getPassword(),agencyregEntity.getEmail()); 
		 regId = agencyregEntity.getId();
		}
		
		
	
	        return "redirect:/deleteUser";
		
		
	}
	

		
	//================================================UPDATE TO ACTIVE AGENCIES===========================================================//
	

	  @RequestMapping(value="/updateToactive",method=RequestMethod.GET) 
	  public String updateToActive(HttpServletRequest req,@ModelAttribute("registerform") RegistrationEntity registration, Model model) 
	  { 
		  
			Registration reg=agencyService.isUserExist(registration.getEmail(),registration.getPassword());
			
			
			
		/*
		 * System.out.println(regi); System.out.println(regi.getActivestatus());
		 */
		
		 
		       
	
         
         
		  boolean isDeleted = false;
	  String uid = req.getParameter("id"); 
	  if (uid != null &&!uid.equals("")) 
	  {
	  int id = Integer.parseInt(uid);
	 
	        
	  isDeleted = agencyService.softDelete(id); 
	  if (isDeleted) {
	  model.addAttribute("sMsg","Deleted Successfully..");
	  
	  } else {
	  
	  model.addAttribute("eMsg", "Failed to deleted.."); }
	  
	  
	  } 
	  
	  return "redirect:viewAgencies?pn=1";
	  
	  }
	 
	 
		//======================================UPDATE TO INACTIVE AGENCIES===========================================================//
		

	  @RequestMapping(value="/updateToInactive",method=RequestMethod.GET) 
	  public String UpdateToInactive(HttpServletRequest req,@ModelAttribute("registerform") RegistrationEntity registration, Model model) 
	  { 
		  

		  boolean isDeleted = false;
	  String uid = req.getParameter("id"); 
	  if (uid != null &&!uid.equals("")) 
	  {
	  int id = Integer.parseInt(uid);
	 
	        
	  isDeleted = agencyService.softInactive(id); 
	  if (isDeleted) {
	  model.addAttribute("sMsg","Deleted Successfully..");
	  
	  } else {
	  
	  model.addAttribute("eMsg", "Failed to deleted.."); }
	  
	  
	  } 
	  
	  return "redirect:viewAgencies?pn=1";
	  
	  }
	 

}
