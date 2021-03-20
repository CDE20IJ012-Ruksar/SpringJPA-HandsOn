package com.cognizant.ormlearn.CountryRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country.Country;

@Repository

public interface CountryRepository extends CrudRepository<Country, String> {
	public List<Country> findByNameContainingOrderByNameAsc(@Param("name") String name);
	public List<Country> findByNameStartingWith(@Param("n") String name);
	
}