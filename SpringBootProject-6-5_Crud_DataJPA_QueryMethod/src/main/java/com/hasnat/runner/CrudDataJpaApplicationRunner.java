package com.hasnat.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasnat.controller.IDoctorController;

@Component
public class CrudDataJpaApplicationRunner implements CommandLineRunner {
	@Autowired
	private IDoctorController docController;

	@Override
	public void run(String... args) throws Exception {
		//docController.findAllDoctorByIncomeRange(120000, 200000).forEach(System.out::println);
		
		docController.findAllDoctorBySpecialization("Cardiologist", "Orthopedic").forEach(System.out::println);
		
		//docController.findAllDoctorNameByIncomeRange(120000, 200000).forEach(System.out::println);
		
		/*docController.findAllDoctorNameAndSpecializationByIncomeRange(120000, 200000).forEach(row -> {
		    Object[] data = (Object[]) row; // Explicit cast to Object[]
		    System.out.println("Name: " + (String) data[0] + ", Specialization: " + (String) data[1]);
		});*/
		
		/*System.out.println(docController.getNoOfDoctor());
		
		Object []aggregateData = (Object[])docController.showAggregateData();
		System.out.println(aggregateData[0]);
		System.out.println(aggregateData[1]);
		System.out.println(aggregateData[2]);
		System.out.println(aggregateData[3]);
		System.out.println(aggregateData[4]);*/
		
		//docController.hikeDoctorIncomeBySpecialization("Cardiologist", 15);
		//docController.deleteDocterBySalaryRange(12000);
		//docController.registerDoctor("Scott", "Cardiologist", 220000);
		//docController.showSystemDate();
		//docController.createTable();
		
		
		//System.out.println(docController.deleteDocterBySalaryRange(127000));
		
		System.out.println(docController.showSystemDate());
		System.out.println(docController.createTable());
		
		//docController.findAllDoctorBySpecialization("Cardiologist", "Orthopedic").forEach(System.out::println);
		
	}
	
	
	

}
