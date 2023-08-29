package com.ats.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ats.entity.RegistrationEntity;
import com.ats.jparepo.AgencyRegistrationRepository;
import com.ats.pojo.Registration;






@Service
public class AgencyManagmentServiceImpl implements AgencyManagementService {

	
	final static Logger Log = Logger.getLogger(AgencyManagementService.class);
	@Autowired
	private AgencyRegistrationRepository agencyRegRepo;
	
	@Override
	public RegistrationEntity save(RegistrationEntity agencyregEntity) {
		
		
		agencyregEntity.setActivestatus("Y");
		agencyregEntity.setLockstatus("locked");
		
		
		
		return agencyRegRepo.save(agencyregEntity);
	}

	public boolean updateSatus(String  email) {
		
		
		
		agencyRegRepo.update(email);
				
				return true;
			}



		public boolean updatePwd(String confimpassword,String email) {
			

			agencyRegRepo.save(confimpassword,email);
			 return true;
		}

		
		
		//============================================================VIEW ALL AGENCIES (PAGINATION)===============================================//
		
		
		@Override
		public ArrayList<RegistrationEntity> getAllUsers(PageRequest page) {
			
			  
			  Page<RegistrationEntity> items = agencyRegRepo.findAll(page);
			  
			  ArrayList<RegistrationEntity> users = new ArrayList<RegistrationEntity>();
			  
			  if (!items.isEmpty()) 
			  { 
			  for (RegistrationEntity agencies : items) 
			  { 
			 
				
				  agencies.setFirstname(agencies.getFirstname());
				  agencies.setLastname(agencies.getLastname());
				  agencies.setEmail(agencies.getEmail());
				  agencies.setPhonum(agencies.getPhonum());
				
			 
			  
				  users.add(agencies);
			  
			  }
			  } 
			  
			 
			return users; 
		}

		@Override
		public Page<RegistrationEntity> findAll(PageRequest page) {
			
			return agencyRegRepo.findAll(page);
		}

		@Override
		public boolean softDelete(Integer id) {
			
			agencyRegRepo.softDetelte(id);
			
			return true;
		}

		public Registration isUserExist(String email, String password) {
			Log.info(""+email+"...."+password);	
			Registration regUser=new Registration();
				Optional<RegistrationEntity> regData = agencyRegRepo.getRegData(email, password);
				if(regData.isPresent()) {
					RegistrationEntity regEntity = regData.get();
					BeanUtils.copyProperties(regEntity, regUser);
					Log.info(""+regEntity);
				}
				Log.info(""+regUser);
			return regUser;
			
		}

		@Override
		public boolean softInactive(Integer id) {
			agencyRegRepo.softInactive(id);
			return true;
		}

	
	

}
