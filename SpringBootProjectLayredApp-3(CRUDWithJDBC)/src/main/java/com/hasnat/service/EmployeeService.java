package com.hasnat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hasnat.dao.IEmployeeDAO;
import com.hasnat.model.Employee;

@Service("empService")
public class EmployeeService implements IEmployeeMgmtService {
	@Autowired
	@Qualifier("oracleEmpDAO")
	private IEmployeeDAO empDAO;

	@Override
	public List<Employee> fetchEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		//convert the desgs(inputs) to upper letters(b.logice)
		desg1=desg1.substring(0,1).toUpperCase()+desg1.substring(1).toLowerCase();
		desg2=desg2.substring(0,1).toUpperCase()+desg2.substring(1).toLowerCase();
		desg3=desg3.substring(0,1).toUpperCase()+desg3.substring(1).toLowerCase();
		//use DAO
		List<Employee> list= empDAO.showEmployeeByDesg(desg1,desg2,desg3);
		//calculate gross Salary and netSalary(b.logice)
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.4));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.15));
		});
		return list;
	}
	@Override
	public String registerEmployee(Employee emp) throws Exception {
		// use DAO
		int count = empDAO.insertEmployee(emp);
		return count == 0 ? "Employee not registed " : "Employee is registered";
	}

}
