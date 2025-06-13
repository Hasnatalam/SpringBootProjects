package com.hasnat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasnat.entity.CallerTuneInfo;
import com.hasnat.repository.ICallerTuneRepository;

@Service
public class CallerTuneService {
	@Autowired
	ICallerTuneRepository callerRepo;
	
	public String setCallerTune(CallerTuneInfo ct) {
		callerRepo.save(ct);
		return ct.getTuneName()+" set as callerTune";
	}
	public String updateCallerTune(Integer id, String tuneName) {
		Optional<CallerTuneInfo> opt = callerRepo.findById(id);
		if(opt.isPresent()) {
			CallerTuneInfo callerTuneInfo = opt.get();
			callerTuneInfo.setTuneName(tuneName);
			callerRepo.save(callerTuneInfo);
			return tuneName+" set as new callertune";
		}
		
		else return "Caller tune not found with this id";
		
	}
	public List<CallerTuneInfo> getCallerTunes(){
		return callerRepo.findAll();
	}
}
