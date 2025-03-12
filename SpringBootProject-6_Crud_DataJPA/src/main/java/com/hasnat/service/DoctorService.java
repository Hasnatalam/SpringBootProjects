package com.hasnat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasnat.entity.Doctor;
import com.hasnat.repository.IDoctorRepository;

@Service
public class DoctorService implements IDoctorService{
	@Autowired
	IDoctorRepository docRepo;

	@Override
	public String saveDoctor(Doctor d) {
		docRepo.save(d);
		return d.getName()+" Registerd";
	}

	@Override
	public String saveAllDoctor(List<Doctor> doctors) {
		docRepo.saveAll(doctors);
		return "All data inserted";
	}

	@Override
	public Optional<Doctor> findDoctorById(Integer id) {
		System.out.println(id);
		return  docRepo.findById(id);
		
	}

	

	@Override
	public List<Doctor> findAllDoctor() {
		return (List<Doctor>) docRepo.findAll();
		
	}

	@Override
	public List<Doctor> findAllDoctorById(List<Integer> ids) {
		
		return (List<Doctor>) docRepo.findAllById(ids);
	}
	
	@Override
	public boolean existsDoctorById(Integer id) {
		return docRepo.existsById(id);
		
	}
	
	@Override
	public Long countDoctor() {
		
		return docRepo.count();
	}

	@Override
	public void deleteDoctorById(Integer id) {
		docRepo.deleteById(id);
		
	}

	@Override
	public void deleteDoctor(Doctor d) {
		docRepo.delete(d);
	}

	@Override
	public void deleteAllDoctorById(List<Integer> ids) {
		docRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAllDoctor(List<Doctor> entities) {
		docRepo.deleteAll(entities);
	}

	@Override
	public void deleteAllDoctor() {
		docRepo.deleteAll();
	}

}
