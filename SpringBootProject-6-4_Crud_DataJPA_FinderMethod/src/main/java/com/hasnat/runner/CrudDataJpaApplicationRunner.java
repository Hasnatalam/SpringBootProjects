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
		//docController.findAllBySpecialization("cardiologist").stream().sorted(Comparator.comparing(Doctor::getName)).forEach(System.out::println);
		//docController.findAllBySpecialization("cardiologist", true, "name").forEach(System.out::println);;
		docController.findAllByName("john smith").forEach(System.out::println);
		//System.out.println(docController.findByName("john smith"));// This can lead to IncorrectResultSizeDataAccessException because there 2 values available in database
		System.out.println(docController.findByName("ava moore"));// This will work beacuse there is only one data name "ava moore"
		docController.findByIncomeBetween(120000, 200000).forEach(System.out::println);
	}
	
	

}
