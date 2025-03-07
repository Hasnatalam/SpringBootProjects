package com.hasnat;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hasnat.controller.EmployeeController;
import com.hasnat.model.Employee;

@SpringBootApplication
public class FetchingAPI {


	public static void main(String[] args) throws Exception {
		ApplicationContext ctx =SpringApplication.run(FetchingAPI.class, args);
		
		EmployeeController ec= ctx.getBean("econtroller",EmployeeController.class);
		
		List<Employee> employees = ec.showAllEmployee();
		employees.forEach(System.out::println);
	}

}
