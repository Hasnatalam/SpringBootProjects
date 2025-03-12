package com.hasnat.repository;

import org.springframework.data.repository.CrudRepository;

import com.hasnat.entity.Doctor;

public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {
	
}
