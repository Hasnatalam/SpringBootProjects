package com.hasnat;


import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hasnat.controller.PayrollOperationsController;
import com.hasnat.model.Employee;

@SpringBootApplication
public class ApplicationToFetch {
 
	public static void main(String[] args) {
			
		ApplicationContext ctx = SpringApplication.run(ApplicationToFetch.class, args);
		try(Scanner sc = new Scanner(System.in);
					
				){
			//get controller Spring bean class object ref
	PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
	//Read input from end user
	System.out.println("Enter Desg1::");
	String desg1=sc.next();
	System.out.println("Enter Desg2::");
	String desg2=sc.next();
	System.out.println("Enter Desg3::");
	String desg3=sc.next();
	//Invoke the b.method
	
		List<Employee> list= controller.showEmployeesByDesgs(desg1,desg2,desg3);
	System.out.println("Employee beloning to "+desg1+" "+desg2+" "+desg3+" are ");
	list.forEach(emp->{System.out.println(emp);
	});
	
}//try

catch(Exception e) {
	System.out.println("Internal Problem::"+e.getMessage());
	e.printStackTrace();
}

}//end of main method
}//end of the class
