package com.hasnat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasnat.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	
}
