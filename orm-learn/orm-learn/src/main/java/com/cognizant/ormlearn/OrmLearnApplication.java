package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country.Country;
import com.cognizant.ormlearn.service.CountryService.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	public static void main(String[] args) throws CountryNotFoundException {
	ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
	countryService = context.getBean(CountryService.class);
	LOGGER.info("Inside main");
	testGetAllCountries();
	getAllCountriesTest();
	testAddCountry();
	testUpdateCountry();
	testDeleteCountry();
}

private static void testGetAllCountries() {
	LOGGER.info("Start");
	List<Country> countries = countryService.getAllCountries();
	LOGGER.debug("countries={}", countries);
	LOGGER.info("End");
}

private static void getAllCountriesTest() throws CountryNotFoundException {
	LOGGER.info("Start");
	Country country = countryService.findCountryByCode("IN");
	LOGGER.debug("Country:{}", country);
	LOGGER.info("End");

	}

private static void testAddCountry() throws CountryNotFoundException {
	Country country = new Country();
	country.setCode("BN");
	country.setName("Bangalore");
	countryService.addCountry(country);
	LOGGER.info("Adding Country");
	Country countryTest = countryService.findCountryByCode("BN");
	LOGGER.debug("Country:{}", countryTest);
	LOGGER.info("Country Added");
	
}

private static void testUpdateCountry() throws CountryNotFoundException {
	countryService.updateCountry("BN","Bangaloreee");
	LOGGER.info("Update Country Code");
	Country countryTest = countryService.findCountryByCode("BN");
	LOGGER.debug("Country:{}", countryTest);
	LOGGER.info("Updated Country Code");
	
}

private static void testDeleteCountry() throws CountryNotFoundException {
	countryService.deleteCountry("BN");
	
}
}