package com.ats.restcontrollers;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.entity.RegistrationDetailsId;
import com.ats.entity.RegistrationEntity;
import com.ats.jparepo.RegistrationRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api
@RestController
public class UserRestController {
	
	
	@Autowired
	private RegistrationRepository regRepo;
	

	@ApiOperation("This Method is Used for users")
	@ApiResponse(response=String.class,message="String Value",code=200) 
	
	@GetMapping(value="/get",produces= {"application/json","application/xml"})
	public RegistrationEntity getUserById(@RequestParam("id") Integer id)
	{
		
		
		RegistrationEntity entity=new RegistrationEntity();
		Optional<RegistrationEntity> opt=regRepo.findById(id);
		RegistrationEntity regEntity=opt.get();
		/*
		 * Registration reg=new Registration(); BeanUtils.copyProperties(reg, entity);
		 */
		return regEntity;
		
	}
}
