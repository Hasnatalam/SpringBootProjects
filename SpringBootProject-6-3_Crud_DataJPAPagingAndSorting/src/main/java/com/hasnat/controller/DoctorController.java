package com.hasnat.controller;

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
	public Page<Doctor> findAllByPagingAndSorting(int pageNo, int pageSize, boolean asc, String... props) {
		
		return docService.findAllByPagingAndSorting(pageNo, pageSize, asc, props);
	}

	@Override
	public void showDataThroughPagination(int pageSize) {
		docService.showDataThroughPagination(pageSize);
	}

	
	


}
