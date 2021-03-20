package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.CountryRepository.CountryRepository;
import com.cognizant.ormlearn.model.Country.Country;

@SpringBootApplication
public class OrmLearnApplication {
	
	public static void main(String[] args)  {
		
		 SpringApplication.run(OrmLearnApplication.class, args);
		 }
}