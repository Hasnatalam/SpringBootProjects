package com.hasnat.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.hasnat.model.Employee;
@Repository("oracleDao")
@Profile({"uat","prod"})
public class OracleEmployeeDAO implements IEmployeeDAO {
	@Autowired
	DataSource ds;

	private static String empSelectQuery = "SELECT * FROM EMPLOYEE";
	private static String empInsertQuery = "INSERT INTO EMPLOYEE VALUES (EMP_SEQ.NEXTVAL,?, ?, ?, ?)";

	@Override
	public List<Employee> showAllEmployee() throws Exception {
		List<Employee> list = new ArrayList<>();
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(empSelectQuery);
				ResultSet rs = ps.executeQuery();) {
			System.err.println("Connected");

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setDesg(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setDeptno(rs.getInt(5));
				list.add(emp);
			}
		} catch (SQLException se) {
			throw se;
		}

		catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public int saveEmployee(Employee emp) throws Exception {

		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(empInsertQuery);) {
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getDeptno());
			int count = ps.executeUpdate();
			return count;
		} catch (SQLException se) {

			throw se;

		} catch (Exception e) {
			throw e;
		}

	}

}
