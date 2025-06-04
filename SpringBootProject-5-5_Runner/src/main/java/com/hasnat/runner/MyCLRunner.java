package com.hasnat.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasnat.controller.EmployeeController;
import com.hasnat.model.Employee;
@Component
public class MyCLRunner implements CommandLineRunner {
	@Autowired
	EmployeeController ec;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		List<Employee> employees = ec.showAllEmployee();
		employees.forEach(System.out::println);
	}

}
