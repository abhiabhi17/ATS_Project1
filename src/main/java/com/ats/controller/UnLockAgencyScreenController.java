package com.ats.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ats.AppConstants.AppConstants;
import com.ats.appproperties.AppProperties;
import com.ats.entity.AgencyRegistrationEntity;
import com.ats.entity.RegistrationEntity;
import com.ats.pojo.AgencyRegistration;
import com.ats.pojo.Login;
import com.ats.pojo.Registration;
import com.ats.service.AgencyManagementService;



@Controller
public class UnLockAgencyScreenController {

	

	final static Logger Log = Logger.getLogger(UnLockAgencyScreenController.class);
	@Autowired
	@Qualifier("app")
	private AppProperties props;

	@Autowired
	private AgencyManagementService agencyService;

	@RequestMapping(value = "/unlockagencyScreen")
	public String loginForm(Model model, @ModelAttribute("unlockform") Registration registration) {

		model.addAttribute("unlock", new Registration());
	
		return "unlockAgencyScreen";
	}


	@RequestMapping(value = "/unlockScreenAgency", method = RequestMethod.POST)
	public String unlockUser(@RequestParam("email") String email,

			@ModelAttribute("unlockform") Registration registration, Model model, RedirectAttributes redirectAttributes,
			HttpServletRequest request,Login login) {

	RegistrationEntity agencyRegEntity = new RegistrationEntity();

		BeanUtils.copyProperties(registration, agencyRegEntity);

		
		String password = request.getParameter("password");
		  
		     String newpassword= request.getParameter("newpassword");
		   String confimpassword=  request.getParameter("confirmpassword");
		   
		  Log.info(newpassword);
		  Log.info(confimpassword);
			   if(confimpassword.equals(newpassword))
			   {
				   agencyRegEntity.setPassword(confimpassword);
				   
			   model.addAttribute("users", agencyService.updatePwd(confimpassword, email));
				model.addAttribute("users", agencyService.updateSatus(email));
				model.addAttribute("unlock",new Login());
				return "loginpage";
			   }
			   
			   else
			   {
				   return "errorpage";
			   }
	

	}
	
	//===============================VIEW AGENCINES(PAGINATION)==============================================================//
	
	
	@RequestMapping(value="/viewAgencies")
	public String agencyList(Model model,@ModelAttribute("agency") Registration registration,@RequestParam("pn") Integer currentPageNo)
	{
		
		
		RegistrationEntity agencyRegEntity = new RegistrationEntity();

		BeanUtils.copyProperties(registration, agencyRegEntity);
		
		Integer pageSize=2;
		PageRequest page =PageRequest.of(currentPageNo-1, pageSize);
		   List<RegistrationEntity> pageData =  agencyService.getAllUsers(page);
		
		   Page<RegistrationEntity> PageData = agencyService.findAll(page);
		     List<RegistrationEntity> agencies= PageData.getContent();
		            int totalPages = PageData.getTotalPages();
		
		
		  
	           model.addAttribute("tp", totalPages);
	           model.addAttribute("cp", currentPageNo);
		
	        model.addAttribute("agencyList", pageData);
	        
		return AppConstants.DISPLAY_AGENCIES_LIST;
	}
	
	

	
}
