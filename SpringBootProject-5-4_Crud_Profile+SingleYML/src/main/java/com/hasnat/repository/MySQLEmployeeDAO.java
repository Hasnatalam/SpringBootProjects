package com.hasnat.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.hasnat.model.Employee;

@Repository("mysqlDao")
@Profile({"dev","test"})
public class MySQLEmployeeDAO implements IEmployeeDAO {
	@Autowired
	DataSource ds;
	public static final String empSelectQuery = "SELECT * FROM EMPLOYEE";

	@Override
	public List<Employee> showAllEmployee() throws Exception {
		List<Employee> list = new ArrayList<>();

		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(empSelectQuery);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setDesg(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setDeptno(rs.getInt(5));
				list.add(emp);

			}
		}
		return list;
	}

	@Override
	public int saveEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
