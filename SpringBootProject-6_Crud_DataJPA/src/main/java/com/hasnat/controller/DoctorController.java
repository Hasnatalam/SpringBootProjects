package com.hasnat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hasnat.entity.Doctor;
import com.hasnat.service.IDoctorService;

@Controller
public class DoctorController implements IDoctorController{
	@Autowired
	IDoctorService docService;

	@Override
	public String saveDoctor(Doctor d) {
		
		return docService.saveDoctor(d);
	}

	@Override
	public String saveAllDoctor(List<Doctor> doctors) {
		
		return docService.saveAllDoctor(doctors);
	}

	@Override
	public Optional<Doctor> findDoctorById(Integer id) {
		System.err.println(id);
		return docService.findDoctorById(id);
	}

	@Override
	public List<Doctor> findAllDoctor() {
		
		return docService.findAllDoctor();
	}

	@Override
	public List<Doctor> findAllDoctorById(List<Integer> ids) {
		
		return docService.findAllDoctorById(ids);
	}

	@Override
	public boolean existsDoctorById(Integer id) {
		
		return docService.existsDoctorById(id);
	}

	@Override
	public Long countDoctor() {
		
		return docService.countDoctor();
	}

	@Override
	public void deleteDoctorById(Integer id) {
		docService.deleteDoctorById(id);
	}

	@Override
	public void deleteDoctor(Doctor d) {
		docService.deleteDoctor(d);
	}

	@Override
	public void deleteAllDoctorById(List<Integer> ids) {
		docService.deleteAllDoctorById(ids);
	}

	@Override
	public void deleteAllDoctor(List<Doctor> entities) {
		docService.deleteAllDoctor(entities);
	}

	@Override
	public void deleteAllDoctor() {
		docService.deleteAllDoctor();
	}
	

}
