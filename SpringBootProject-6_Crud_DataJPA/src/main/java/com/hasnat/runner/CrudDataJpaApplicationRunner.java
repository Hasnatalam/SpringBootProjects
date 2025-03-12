package com.hasnat.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasnat.controller.IDoctorController;
import com.hasnat.entity.Doctor;

@Component
public class CrudDataJpaApplicationRunner implements CommandLineRunner {
	@Autowired
	IDoctorController docController;

	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {
		Doctor doctor = new Doctor("Dr. John Smith", "Cardiologist", 180000);
		Doctor doctor1 = new Doctor(1, "Dr. John Smith", "Cardiologist", 180000);
		List<Doctor> deleteDoctors = List.of(
				new Doctor(53, "Dr. Liam", "Dermatologist", 120000),
				new Doctor(54, "Dr. Olivia", "Pediatrician", 140000));
		List<Doctor> updateDoctors = List.of(
				new Doctor(53, "Dr. Liam", "Dermatologist", 120000),
				new Doctor(54, "Dr. Olivia", "Pediatrician", 140000));
		/*// #1 Using save method
		
		
		System.out.println(docController.saveDoctor(doctor));
		*/
		
		docController.saveDoctor(new Doctor(52,"Dr. Emma", "Neurologist", 175000));
		

		List<Doctor> doctors = List.of(
				new Doctor("Dr. Emma Brown", "Neurologist", 175000),
				new Doctor("Dr. Liam Johnson", "Dermatologist", 120000),
				new Doctor("Dr. Olivia Wilson", "Pediatrician", 140000),
				new Doctor("Dr. Noah Anderson", "Orthopedic", 160000),
				new Doctor("Dr. Sophia Thomas", "Ophthalmologist", 130000),
				new Doctor("Dr. William Martinez", "Radiologist", 155000),
				new Doctor("Dr. Ava Garcia", "ENT Specialist", 135000),
				new Doctor("Dr. James Rodriguez", "Psychiatrist", 145000),
				new Doctor("Dr. Charlotte Lee", "Gynecologist", 170000));
		List<Integer> list = List.of(1, 2, 3, 4, 5);

		// #2 Using saveAll method
		//docController.saveAllDoctor(doctors);
		
		docController.saveAllDoctor(updateDoctors);

		Integer id = 1;

		// #3 Using findById
		System.out.println(docController.findDoctorById(id));
		// #4 Using findAll
		System.out.println(docController.findAllDoctor());
		// #5 Using findAllById
		System.out.println(docController.findAllDoctorById(list));

		Boolean isAvailable = docController.existsDoctorById(id);
		String msg = isAvailable ? "Id " + id + " is available" : "Id " + id + " is not available";
		System.out.println(msg);
		/*
		// #8 Using deleteById
		docController.deleteDoctorById(2);
		// #9 Using delete(Entity)
		docController.deleteDoctor(doctor1);
		// #10 Using deleteAll(Entity's)
		docController.deleteAllDoctor(deleteDoctors);
		// #11 Using deleteAllById
		docController.deleteAllDoctorById(list);
		// #12 Using deleteAll
		docController.deleteAllDoctor();
		System.out.println(docController.countDoctor());*/
		
		docController.deleteAllDoctorById(List.of(102,103,104,105,106,107,108,109,110));
		System.out.println(docController.countDoctor());
	}

}
