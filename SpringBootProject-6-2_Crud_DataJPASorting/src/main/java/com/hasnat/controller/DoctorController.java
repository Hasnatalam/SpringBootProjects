package com.hasnat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.hasnat.entity.Doctor;
import com.hasnat.service.IDoctorService;

@Controller
public class DoctorController implements IDoctorController{
	@Autowired
	private IDoctorService docService;

	@Override
	public String saveAllDoctor(List<Doctor> doctors) {
		
		return docService.saveAllDoctor(doctors);
	}

	@Override
	public List<Doctor> findAllBySort(boolean asc, String... props) {
		
		return docService.findAllBySort(asc, props);
	}

	@Override
	public List<Doctor> findAllBySpecificCondition(Doctor doctor, boolean asc, String... props) {
	    System.out.println("Controller: Fetching doctors with specialization = " + doctor.getSpecialization());
	    return docService.findAllBySpecificCondition(doctor, asc, props);
	}

	@Override
	public Page<Doctor> findAllByPagingAndSorting(int pageNo, int pageSize, boolean asc, String... props) {
		
		return docService.findAllByPagingAndSorting(pageNo, pageSize, asc, props);
	}

	
	


}
