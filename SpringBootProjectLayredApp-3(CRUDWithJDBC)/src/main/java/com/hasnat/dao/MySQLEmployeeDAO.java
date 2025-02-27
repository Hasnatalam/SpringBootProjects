package com.hasnat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hasnat.model.Employee;

@Repository("mysqlEmpDAO")
public class MySQLEmployeeDAO implements IEmployeeDAO {
	@Autowired
	private DataSource ds;// HAS-A Property

//SQL Query
	private static final String GET_EMPS_QUERY ="SELECT EMPNO, ENAME, DESG, SALARY, DEPTNO FROM EMPLOYEE WHERE DESG IN (?, ?, ?)ORDER BY DESG";
	private static final String INSERT_EMP_QUERY = "INSERT INTO Employee (ENAME, DESG, SALARY, DEPTNO)VALUES (?, ?, ?, ?)";
	 
	
	@Override
	public List<Employee> showEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		// get pooled jdbc con
		// get PreparedStatement object with pre-compiled SQL Query
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_QUERY);) {
			// Set values to query params
			System.out.println("Entry");
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			// execute the SQL Query
			try (ResultSet rs = ps.executeQuery()) {
				list = new ArrayList<>();
				// process the ResultSet object to List<Employee object
				while (rs.next()) {

					// copy each record into model class obj
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					// add Employee class object to List Collection
					list.add(emp);
				} // while
			} // nested try

		} // outer try

		catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	public int insertEmployee(Employee emp) throws Exception {
		try (// get poll to jdbc connection object
				Connection con = ds.getConnection();
				// Create PreparedStatement object
				PreparedStatement ps = con.prepareStatement(INSERT_EMP_QUERY)) {
			// set value to query params
			System.out.println("MySQLEmployeeDAO.insertEmployee()");
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getDeptno());
			// Execute the SQL query
			int count = ps.executeUpdate();
			return count;

		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		}
	}
}
