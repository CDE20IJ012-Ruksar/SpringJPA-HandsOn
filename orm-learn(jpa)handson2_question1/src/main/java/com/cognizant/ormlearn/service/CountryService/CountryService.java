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
	
}