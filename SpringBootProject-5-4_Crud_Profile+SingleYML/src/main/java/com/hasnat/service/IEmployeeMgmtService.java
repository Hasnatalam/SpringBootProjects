package com.hasnat.service;

import java.util.List;

import com.hasnat.model.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> fetchEmployee() throws Exception;
	public String saveEmployee(Employee e) throws Exception;

}
