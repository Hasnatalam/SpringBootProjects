package com.hasnat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hasnat.model.Employee;
import com.hasnat.service.EmployeeService;
@Controller("econtroller")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	public List<Employee> showAllEmployee() throws Exception{
		return empService.fetchEmployee();
	}
	
	public String saveEmployee(Employee e) throws Exception {
		return empService.saveEmployee(e);
	}
}
