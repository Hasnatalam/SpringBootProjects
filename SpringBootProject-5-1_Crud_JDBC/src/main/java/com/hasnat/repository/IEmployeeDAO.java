package com.hasnat.repository;

import java.util.List;
import com.hasnat.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> showAllEmployee() throws Exception;
	public int saveEmployee(Employee emp)throws Exception;
}
