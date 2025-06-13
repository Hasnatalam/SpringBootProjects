package com.hasnat.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasnat.controller.CallerTuneController;
import com.hasnat.entity.CallerTuneInfo;
@Component
public class ApplicationRunner implements CommandLineRunner {
	
	@Autowired
	CallerTuneController tuneController;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("checkkkkkkk");
		CallerTuneInfo ct = new CallerTuneInfo();
		ct.setTuneName("zzz");
		//System.out.println(tuneController.setCallerTune(ct));
		
		tuneController.updateCallerTune(202, "yyy");
		
		tuneController.getCallerTunes().forEach(System.out::println);
		
	}

}
