package com.hasnat.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public final class ElectricEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("ElectricEngine.startEngine()");

	}
	@Override
	public void stopEngine() {
		
		System.out.println("ElectricEngine.stopeEngine()");
	}
}