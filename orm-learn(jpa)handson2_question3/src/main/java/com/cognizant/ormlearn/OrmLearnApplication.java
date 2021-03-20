package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication

public class OrmLearnApplication {
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static void main(String[] args) throws ParseException   {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		 skillService = context.getBean(SkillService.class);
		 testGetEmployee();
		 testAddEmployee();
		 testUpdateEmployee();
		 testGetDepartment();
		 testAddSkillToEmployee();
		 }
	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
		}
	
	private static void testAddEmployee() throws ParseException {
		Employee emp=new Employee();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date =formatter.parse("1999-09-01");
		emp.setDateOfBirth(date);
		emp.setId(5);
		emp.setName("XYZA");
		emp.setPermanent(false);
		emp.setSalary(new BigDecimal(21000.00));
		Department dept=departmentService.get(1);
		emp.setDepartment(dept);
		employeeService.save(emp);
		LOGGER.info("Start");
		Employee employee = employeeService.get(5);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
		}
	
	 	private static void testUpdateEmployee() {
		Employee emp=employeeService.get(5);
		Department dept=departmentService.get(3);
		emp.setDepartment(dept);
		employeeService.save(emp);
		LOGGER.info("Start");
		Employee employee = employeeService.get(5);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
		}
	 	
	 	private static void testGetDepartment() {
		Department dept=departmentService.get(1);
		LOGGER.info("Start");
		LOGGER.debug("Department:{}", dept);
		LOGGER.debug("Employee's List:{}", dept.getEmployeeList());
		LOGGER.info("End");
	    }
	 	
	 	private static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(3);
		Skill skill = skillService.get(1);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		}













}