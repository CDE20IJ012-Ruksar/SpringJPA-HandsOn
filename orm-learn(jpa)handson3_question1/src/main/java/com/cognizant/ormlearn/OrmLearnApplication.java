package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import java.text.ParseException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static EmployeeService employeeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static void main(String[] args) throws ParseException   {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		 employeeService = context.getBean(EmployeeService.class);
		 testGetAllPermanentEmployees();
		 testAvgOfDeraprtment();
		 getAllEmployeesNative();
	}
	
	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	public static void testAvgOfDeraprtment() {
		LOGGER.info("Start");
		double avg = employeeService.getAverageSalary(3);
		LOGGER.debug("Average of department 3 is:{}", avg);
		LOGGER.info("End");
	}
	public static void getAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		LOGGER.debug("Employees:{}", employees);
		LOGGER.info("End");
	}
}