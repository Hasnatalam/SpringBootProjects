package com.hasnat.controller;

import java.util.List;
import java.util.Optional;

import com.hasnat.entity.Doctor;

public interface IDoctorController {
	public String saveDoctor(Doctor d);
	public String saveAllDoctor(List<Doctor> doctors);
	
	public Optional<Doctor> findDoctorById(Integer id);
	public List<Doctor>findAllDoctor();
	public List<Doctor> findAllDoctorById(List<Integer> ids);
	
	public boolean existsDoctorById(Integer id);
	public Long countDoctor();
	
	public void deleteDoctorById(Integer id);
	public void deleteDoctor(Doctor d );
	public void deleteAllDoctorById(List<Integer>  ids);
	public void deleteAllDoctor(List<Doctor> entities);
	public void deleteAllDoctor();
}
