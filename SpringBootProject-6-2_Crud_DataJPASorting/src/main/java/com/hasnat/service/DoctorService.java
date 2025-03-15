package com.hasnat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hasnat.entity.Doctor;
import com.hasnat.repository.IDoctorRepository;

@Service
public class DoctorService implements IDoctorService{
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public String saveAllDoctor(List<Doctor> doctors) {
		docRepo.saveAll(doctors);
		return "All Doctor registerd";
	}
	
	@Override
	public List<Doctor> findAllBySort(boolean asc,String...props) {
		Sort sort= Sort.by(asc? Sort.Direction.ASC:Sort.Direction.DESC,props);
		return docRepo.findAll(sort);
	}
	
/*	@Override
	public List<Doctor> findAllBySpecificCondition(Doctor doctor, boolean asc, String... props) {
		Sort sort= Sort.by(asc? Sort.Direction.ASC:Sort.Direction.DESC,props);
		Example<Doctor> example = Example.of(doctor);
		List<Doctor> list = docRepo.findAll(example,sort);
		return list;
	}*/
	
	@Override
	public List<Doctor> findAllBySpecificCondition(Doctor doctor, boolean asc, String... props) {
	    Sort sort = Sort.by(asc ? Sort.Direction.ASC : Sort.Direction.DESC, props);
	    
	    // Use ExampleMatcher to ignore nulls and enable case-insensitive search
	    Example<Doctor> example = Example.of(doctor, ExampleMatcher.matching()
	            .withIgnoreCase()
	            .withIgnorePaths("income")
	            .withIgnoreNullValues());
	
	    return docRepo.findAll(example, sort);
	}

	 @Override
	    public Page<Doctor> findAllByPagingAndSorting(int pageNo, int pageSize, boolean asc, String... props) {
	        Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
	        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
	        return docRepo.findAll(pageable);
	    }
	
	

}
