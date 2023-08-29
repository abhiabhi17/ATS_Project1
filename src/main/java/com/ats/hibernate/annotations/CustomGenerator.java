package com.ats.hibernate.annotations;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator  implements IdentifierGenerator {

	
	
	  public int generateCustId() {
	        Random random = new Random();
	        return random.nextInt(100);
	    }
	  
		public int generateFourDigit() {
			 Random random = new Random();
		        return random.nextInt(1000);
		}


	    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

	      
	        return "hK" + generateCustId()+ generateFourDigit() ;

	    }

	
		
}
