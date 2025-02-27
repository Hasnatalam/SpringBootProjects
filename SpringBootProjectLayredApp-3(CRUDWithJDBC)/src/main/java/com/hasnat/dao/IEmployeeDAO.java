package com.hasnat.dao;

import java.util.List;

import com.hasnat.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> showEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception;

	public int insertEmployee(Employee emp) throws Exception;
}
