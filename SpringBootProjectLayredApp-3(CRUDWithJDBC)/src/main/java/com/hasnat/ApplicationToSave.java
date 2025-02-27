package com.hasnat;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hasnat.controller.PayrollOperationsController;
import com.hasnat.model.Employee;

@SpringBootApplication
public class ApplicationToSave {

	public static void main(String[] args) {
		// try block
		try (ConfigurableApplicationContext ctx = SpringApplication
				.run(ApplicationToSave.class, args);
				Scanner sc = new Scanner(System.in);) {
			// get controller Spring bean class object ref
			PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
			// Read input from end user
			System.out.println("Enter ename::");
			String name = sc.next();
			System.out.println("Enter Desg::");
			String desg = sc.next();
			System.out.println("Enter salary::");
			Double salary = sc.nextDouble();
			System.out.println("Enter Dept no(10,20,30,40)::");
			Integer deptno = sc.nextInt();

			// create employee class object
			Employee emp = new Employee();
			emp.setEname(name);
			emp.setDesg(desg);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			// Invoke the b.method
			String msg = controller.appointEmployee(emp);
			System.out.println(msg);

		} 
		catch (Exception e) {
			System.out.println("Internal Problem::" + e.getMessage());
			e.printStackTrace();
		}

	}
}
