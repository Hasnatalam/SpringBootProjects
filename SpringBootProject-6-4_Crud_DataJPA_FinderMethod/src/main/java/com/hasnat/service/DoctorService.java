package com.hasnat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hasnat.entity.Doctor;
import com.hasnat.repository.IDoctorRepository;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    private IDoctorRepository docRepo;

	@Override
	public List<Doctor> findAllBySpecialization(String name) {
		
		return docRepo.findAllBySpecialization(name);
	}

	@Override
	public List<Doctor> findAllBySpecialization(String name, Boolean asc, String... props) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,props);
		
		return docRepo.findAllBySpecialization(name,sort);
	}
	@Override
	public List<Doctor> findAllByName(String name){
		return docRepo.findAllByName( name);
	}
	
	@Override
	public Doctor findByName(String name){
		return docRepo.findByName( name);
	}

	@Override
	public List<Doctor> findByIncomeBetween(Integer min, Integer max) {
		
		return docRepo.findByIncomeBetween(min, max);
	}
   
}
