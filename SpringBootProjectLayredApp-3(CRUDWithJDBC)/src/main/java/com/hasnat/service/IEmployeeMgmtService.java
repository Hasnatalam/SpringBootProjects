package com.hasnat.service;

import java.util.List;

import com.hasnat.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception;

	public String registerEmployee(Employee emp) throws Exception;
}
