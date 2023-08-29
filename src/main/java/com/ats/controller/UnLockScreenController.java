package com.ats.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ats.appproperties.AppProperties;
import com.ats.entity.RegistrationEntity;
import com.ats.pojo.Login;
import com.ats.pojo.Registration;
import com.ats.service.UserManagementService;

/*This method is used fr loading unlock screen page*/
@Controller
public class UnLockScreenController {


	final static Logger Log = Logger.getLogger(UnLockScreenController.class);
	@Autowired
	@Qualifier("app")
	private AppProperties props;

	@Autowired
	private UserManagementService userService;

	@RequestMapping(value = "/unlockScreen")
	public String loginForm(Model model, @ModelAttribute("unlockform") Registration registration) {

		model.addAttribute("unlock", new Registration());
	
		return "unlockscreen";
	}

	
	
	/*
	 * used for unlcoking account user baesd on email
	 * 
	 * @param email
	 */

	@RequestMapping(value = "/unlockScreenUser", method = RequestMethod.POST)
	public String unlockUser(@RequestParam("email") String email,

			@ModelAttribute("unlockform") Registration registration, Model model, RedirectAttributes redirectAttributes,
			HttpServletRequest request,Login login) {

		RegistrationEntity regEntity = new RegistrationEntity();

		BeanUtils.copyProperties(registration, regEntity);

		
		String password = request.getParameter("password");
		  
		     String newpassword= request.getParameter("newpassword");
		   String confimpassword=  request.getParameter("confirmpassword");
		   
		  Log.info(newpassword);
		  Log.info(confimpassword);
			   if(confimpassword.equals(newpassword))
			   {
			   regEntity.setPassword(confimpassword);
			   model.addAttribute("users", userService.updatePwd(confimpassword, email));
				model.addAttribute("users", userService.updateSatus(email));
				model.addAttribute("unlock",new Login());
				return "loginpage";
			   }
			   
			   else
			   {
				   return "errorpage";
			   }
	

	}

}
