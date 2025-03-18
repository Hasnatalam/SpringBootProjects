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
	public List<Doctor> findAllBySpecialization(String name) {
		
		return docService.findAllBySpecialization(name);
	}

	@Override
	public List<Doctor> findAllBySpecialization(String name, Boolean asc, String... props) {
		
		return docService.findAllBySpecialization(name,asc,props);
	}

	@Override
	public List<Doctor> findAllByName(String name){
		return docService.findAllByName( name);
	}
	
	@Override
	public Doctor findByName(String name){
		return docService.findByName( name);
	}

	@Override
	public List<Doctor> findByIncomeBetween(Integer min, Integer max) {
		
		return docService.findByIncomeBetween(min, max);
	}
   

}
