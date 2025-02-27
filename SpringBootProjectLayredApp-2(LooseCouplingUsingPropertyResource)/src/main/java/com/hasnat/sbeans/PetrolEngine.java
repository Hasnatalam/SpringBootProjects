package com.hasnat.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public final class PetrolEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("PetrolEngine.startEngine()");

	}
	@Override
	public void stopEngine() {
		
		System.out.println("PetrolEngine.stopeEngine()");
	}
}