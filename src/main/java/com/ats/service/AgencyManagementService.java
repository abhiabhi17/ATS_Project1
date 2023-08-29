package com.ats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ats.entity.AgencyRegistrationEntity;
import com.ats.entity.RegistrationEntity;
import com.ats.pojo.AgencyRegistration;
import com.ats.pojo.Registration;


public interface AgencyManagementService {

public RegistrationEntity save(RegistrationEntity agencyregEntity) ;

public boolean updateSatus(String email);

public boolean updatePwd(String confimpassword, String email);

public ArrayList<RegistrationEntity> getAllUsers(PageRequest page);

public Page<RegistrationEntity> findAll(PageRequest page);

public boolean softDelete(Integer id);

public Registration isUserExist(String email, String password);

public boolean softInactive(Integer id);






		

}
