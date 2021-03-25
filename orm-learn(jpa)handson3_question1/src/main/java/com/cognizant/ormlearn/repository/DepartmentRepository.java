package com.cognizant.ormlearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.ormlearn.model.Department;


public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	
}
