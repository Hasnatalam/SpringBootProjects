package com.hasnat.controller;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hasnat.entity.Doctor;

public interface IDoctorController {
	public String saveAllDoctor(List<Doctor> doctors);
	public List<Doctor> findAllBySort(boolean asc,String...props);
	public List<Doctor> findAllBySpecificCondition( Doctor doctor,boolean asc,String...props);
	public Page<Doctor> findAllByPagingAndSorting(int pageNo, int pageSize, boolean asc, String...props);
}
