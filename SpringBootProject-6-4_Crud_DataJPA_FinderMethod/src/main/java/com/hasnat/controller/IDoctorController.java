package com.hasnat.controller;

import java.util.List;

import com.hasnat.entity.Doctor;

public interface IDoctorController {
	public List<Doctor> findAllBySpecialization(String name);
	public List<Doctor> findAllBySpecialization(String name,Boolean asc,String... props);
	Doctor findByName(String name);
	List<Doctor> findAllByName(String name);
	public List<Doctor> findByIncomeBetween(Integer min, Integer max);
}
