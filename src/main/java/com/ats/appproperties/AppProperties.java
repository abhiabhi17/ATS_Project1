package com.ats.appproperties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("app")
@Configuration
@ConfigurationProperties(prefix="ats")
@EnableConfigurationProperties

/* this is used to read 
 * 
 * @author Abhi
 * 
 * properties frm yml file */ 
public class AppProperties {


	private Map <String,String> props=new HashMap<String, String>();

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "AppProperties [props=" + props + "]";
	}

	
		

		
}
