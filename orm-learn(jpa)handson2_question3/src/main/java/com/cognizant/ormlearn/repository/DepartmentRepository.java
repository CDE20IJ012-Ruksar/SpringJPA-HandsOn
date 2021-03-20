package com.cognizant.ormlearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.ormlearn.model.Department;


public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	//public List<Stock> findAllByDateBetween(Date startDate, Date endDate);
	//public List<Stock> findAllByStockopenGreaterThan(BigDecimal price);
}
