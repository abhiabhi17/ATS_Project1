package com.ats.jparepo;

import java.io.Serializable;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.entity.RegistrationEntity;
import com.ats.pojo.Registration;


@Repository
public interface AgencyRegistrationRepository extends JpaRepository <RegistrationEntity,Serializable>
{

	  
	  @Transactional
	  @Modifying
	@Query(value="update registration_dtls set lock_status='unlocked' where email=:email",nativeQuery=true)
     public void update(String email);

	 
	  
	  
	  
	  
	/* This Method is used for updating password with specific email
	 * 
	 *  @Param
	 *  
	 *  */
	  
	  @Transactional
	  @Modifying
	  @Query("update RegistrationEntity r set r.password = ?1 where r.email = ?2")
	
	public void save(String confimpassword,String email);





	  @Transactional
	  @Modifying
	@Query("update RegistrationEntity set activestatus='Y' where id=:id")
	public void softDetelte(Integer id);






	  @Query("select re from RegistrationEntity re where re.email=:email and re.password=:password")
		public Optional<RegistrationEntity> getRegData(String email, String password);





	  @Transactional
	  @Modifying
	@Query("update RegistrationEntity set activestatus='N' where id=:id")

	public void softInactive(Integer id);








		






	  









	


	
}
