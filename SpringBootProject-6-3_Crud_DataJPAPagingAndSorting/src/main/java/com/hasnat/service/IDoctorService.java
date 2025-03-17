package com.hasnat.service;

import org.springframework.data.domain.Page;

import com.hasnat.entity.Doctor;

public interface IDoctorService {
	public Page<Doctor> findAllByPagingAndSorting(int pageNo, int pageSize, boolean asc, String...props);
	public void showDataThroughPagination(int pageSize);
}
