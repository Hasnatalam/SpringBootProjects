package com.hasnat.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehical")
public class Vehical {
		//@Qualifier("pEngine")//But here every time we change the id  manual.  
		@Qualifier("engineType")//It is not for one engine id it for every engine id we can change from property file not touch source code.
		@Autowired
		private IEngine engine;
		
		public void journey(String startPlace, String endPlace ) {
			
			engine.startEngine();
			System.out.println("Journey is started from ::"+startPlace);
		
			System.out.println("Journey is going on::");
			
			engine.stopEngine();
			System.out.println("Journey is ended from::"+endPlace);
		}
}
