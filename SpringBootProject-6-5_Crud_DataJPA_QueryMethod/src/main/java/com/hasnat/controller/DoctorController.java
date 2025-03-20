package com.hasnat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hasnat.entity.Doctor;
import com.hasnat.service.IDoctorService;

@Controller
public class DoctorController implements IDoctorController{
	@Autowired
	private IDoctorService docService;

	@Override
	public List<Doctor> findAllDoctorByIncomeRange(Integer min, Integer max) {
		
		return docService.findAllDoctorByIncomeRange(min, max);
	}

	@Override
	public List<Doctor> findAllDoctorBySpecialization(String sp1, String sp2) {
		
		return docService.findAllDoctorBySpecialization(sp1, sp2);
	}

	@Override
	public List<String> findAllDoctorNameByIncomeRange(Integer min, Integer max) {
		
		return docService.findAllDoctorNameByIncomeRange(min, max);
	}

	@Override
	public List<Object> findAllDoctorNameAndSpecializationByIncomeRange(Integer min, Integer max) {
		
		return docService.findAllDoctorNameAndSpecializationByIncomeRange(min, max);
	}

	@Override
	public Integer getNoOfDoctor() {
		
		return docService.getNoOfDoctor();
	}

	@Override
	public Object showAggregateData() {
		
		return docService.showAggregateData();
	}

	@Override
	public Integer hikeDoctorIncomeBySpecialization(String sp, Integer percentage) {
		
		return docService.hikeDoctorIncomeBySpecialization(sp, percentage);
	}

	@Override
	public String deleteDocterBySalaryRange(Integer income) {
		
		return docService.deleteDocterBySalaryRange(income);
	}

	@Override
	public String registerDoctor(String name, String special, Integer income) {
		
		return docService.registerDoctor(name, special, income);
	}

	@Override
	public String showSystemDate() {
		
		return docService.showSystemDate();
	}

	@Override
	public String createTable() {
		
		return docService.createTable();
	}
	
   

}
