package com.hasnat.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hasnat.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	

	public List<Doctor> findAllBySpecialization(String name);
	public List<Doctor> findAllBySpecialization(String name, Sort sort);
	public List<Doctor> findAllByName(String name);
	public Doctor findByName(String name);
	public List<Doctor> findByIncomeBetween(Integer min, Integer max);
}
