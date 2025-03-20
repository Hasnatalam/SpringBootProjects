package com.hasnat.controller;

import java.util.List;

import com.hasnat.entity.Doctor;

public interface IDoctorController {
	public List<Doctor> findAllDoctorByIncomeRange(Integer min,Integer max);
	public List<Doctor> findAllDoctorBySpecialization(String sp1,String sp2);
	List<String> findAllDoctorNameByIncomeRange(Integer min, Integer max);
	List<Object> findAllDoctorNameAndSpecializationByIncomeRange(Integer min, Integer max);
	public Integer getNoOfDoctor();
	public Object showAggregateData();
	public Integer hikeDoctorIncomeBySpecialization(String sp, Integer percentage);
	public String deleteDocterBySalaryRange(Integer income);
	public String registerDoctor(String name, String special, Integer income);
	public String showSystemDate();
	public String createTable();
	
}
