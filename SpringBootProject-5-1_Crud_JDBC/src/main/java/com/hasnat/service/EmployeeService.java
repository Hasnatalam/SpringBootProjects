package com.hasnat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hasnat.model.Employee;
import com.hasnat.repository.IEmployeeDAO;
@Service("empService")
public class EmployeeService implements IEmployeeMgmtService {
	@Autowired
	@Qualifier("mysqlDao")
	IEmployeeDAO empDAO;

	@Override
	public List<Employee> fetchEmployee() throws Exception {
		List<Employee> list = empDAO.showAllEmployee();
		list.forEach(emp->emp.setGrossSalary(emp.getSalary()+emp.getSalary()*0.4));
		list.forEach(emp->emp.setNetSalary(emp.getGrossSalary()+emp.getGrossSalary()*0.15));
		return list;
	}

	@Override
	public String saveEmployee(Employee e) throws Exception {
		int count=empDAO.saveEmployee(e);
		return count>0 ? "Enployee is registerd" : "Employee not registerd" ;
	}

}
