package com.hasnat.service;

import java.util.List;

import com.hasnat.entity.Doctor;

public interface IDoctorService {
	public List<Doctor> findAllBySpecialization(String name);
	public List<Doctor> findAllBySpecialization(String name,Boolean asc,String... props);
	List<Doctor> findAllByName(String name);
	Doctor findByName(String name);
	public List<Doctor> findByIncomeBetween(Integer min, Integer max);
}
