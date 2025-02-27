package com.hasnat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hasnat.model.Employee;
import com.hasnat.service.IEmployeeMgmtService;

@Controller("payroll")
public class PayrollOperationsController {
	@Autowired
	//@Qualifier("empService")
	private IEmployeeMgmtService empService;

	
	public List<Employee> showEmployeesByDesgs(String desg1,String desg2,String desg3)throws Exception{
		//use service
		List<Employee> list = empService.fetchEmployeeByDesgs(desg1, desg2, desg3);
		return list;
	}
	 
	public String appointEmployee(Employee emp) throws Exception {
		// use Service
		String msg = empService.registerEmployee(emp);
		return msg;
	}
}
