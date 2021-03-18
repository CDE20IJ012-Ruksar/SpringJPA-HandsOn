package com.cognizant.ormlearn.service.CountryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.CountryRepository.CountryRepository;
import com.cognizant.ormlearn.model.Country.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service

public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	@Transactional
	public List<Country> getAllCountries(){
		List<Country> countries=countryRepository.findAll();
		return countries;
	}
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country code not found");
		}
		Country country = result.get();
		return country;
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(String code, String name) {
		Optional<Country> updateCountry = countryRepository.findById(code);
		Country country = updateCountry.get();
		country.setName(name);
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String country_code) {
		countryRepository.deleteById(country_code);
		
	}
}