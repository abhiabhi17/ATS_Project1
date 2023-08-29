package com.ats;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ats.appproperties.AppProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EnableSwagger2
public class AtsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtsProjectApplication.class, args);
	}

}
