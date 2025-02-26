package com.hasnat.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public final class DiselEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("DiselEngine.startEngine()");

	}
	@Override
	public void stopEngine() {
		
		System.out.println("DiselEngine.stopeEngine()");
	}
}