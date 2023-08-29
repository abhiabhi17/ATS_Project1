package com.ats.service;

import java.util.Optional;


import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ats.entity.RegistrationEntity;
import com.ats.jparepo.RegistrationRepository;
import com.ats.pojo.Registration;


@Service
public class UserManagementService {


	final static Logger Log = Logger.getLogger(UserManagementService.class);
	@Autowired
	private RegistrationRepository regRepo;
	
	
	public RegistrationEntity save(RegistrationEntity regEntity) {
		
		regEntity.setRole("user");
		regEntity.setLockstatus("locked");
		regEntity.setActivestatus("Y");
		return regRepo.save(regEntity);
	}


	
public boolean updateSatus(String  email) {
		
	
	
 regRepo.update(email);
		
		return true;
	}



public boolean updatePwd(String confimpassword,String email) {
	

	 regRepo.save(confimpassword,email);
	 return true;
}



public Registration isUserExist(String email, String password) {
	Log.info(""+email+"...."+password);	
	Registration regUser=new Registration();
		Optional<RegistrationEntity> regData = regRepo.getRegData(email, password);
		if(regData.isPresent()) {
			RegistrationEntity regEntity = regData.get();
			BeanUtils.copyProperties(regEntity, regUser);
			Log.info(""+regEntity);
		}
		Log.info(""+regUser);
	return regUser;
	
}

}
