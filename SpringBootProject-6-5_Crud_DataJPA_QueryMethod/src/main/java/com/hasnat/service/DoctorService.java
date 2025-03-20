package com.hasnat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasnat.entity.Doctor;
import com.hasnat.repository.IDoctorRepository;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    private IDoctorRepository docRepo;

	@Override
	public List<Doctor> findAllDoctorByIncomeRange(Integer min, Integer max) {
		
		return docRepo.findAllDoctorByIncomeRange(min, max);
	}

	@Override
	public List<Doctor> findAllDoctorBySpecialization(String sp1, String sp2) {
		
		return docRepo.findAllDoctorBySpecialization(sp1, sp2);
	}

	@Override
	public List<String> findAllDoctorNameByIncomeRange(Integer min, Integer max) {
		
		return docRepo.findAllDoctorNameByIncomeRange(min, max);
	}

	@Override
	public List<Object> findAllDoctorNameAndSpecializationByIncomeRange(Integer min, Integer max) {
		
		return docRepo.findAllDoctorNameAndSpecializationByIncomeRange(min, max);
	}

	@Override
	public Integer getNoOfDoctor() {
		
		return docRepo.getNoOfDoctor();
	}

	@Override
	public Object showAggregateData() {
		
		return docRepo.fetchAggregateData();
	}

	@Override
	public String deleteDocterBySalaryRange(Integer income) {
		int count = docRepo.deleteDocterBySalaryRange(income);
		return count>0?count+"Row deleted":"Deletion failed Row doesn't found ";
	}

	@Override
	public String registerDoctor(String name, String special, Integer income) {
		
		//return "Saved"+docRepo.registerDoctor(name, special, income);
		return null;
	}

	@Override
	public String showSystemDate() {
		return docRepo.showSystemDate();
	}

	@Override
	public String createTable() {
		Integer table = docRepo.createTable();
		return table==0?"Table Created":"Table Not Created";
	}

	@Override
	public Integer hikeDoctorIncomeBySpecialization(String sp, Integer percentage) {
		
		return docRepo.hikeDoctorIncomeBySpecialization(sp, percentage);
	}

   
}
