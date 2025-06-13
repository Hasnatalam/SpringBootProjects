package com.hasnat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hasnat.entity.CallerTuneInfo;
import com.hasnat.service.CallerTuneService;

@Controller
public class CallerTuneController {
	@Autowired
	CallerTuneService tuneService;
	
	public String setCallerTune(CallerTuneInfo ct) {
		return tuneService.setCallerTune(ct);
	}
	public String updateCallerTune(Integer id, String tuneName) {
		 return tuneService.updateCallerTune(id, tuneName);
		
	}
	public List<CallerTuneInfo> getCallerTunes(){
		return tuneService.getCallerTunes();
	}
}
