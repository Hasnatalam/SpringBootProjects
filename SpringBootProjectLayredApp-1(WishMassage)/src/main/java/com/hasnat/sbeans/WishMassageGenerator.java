package com.hasnat.sbeans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMassageGenerator {
	@Autowired
	private LocalTime lt;
	public String generateMassage(String name) {
		int hour = lt.getHour();
		if(hour>=6&&hour<=12)return "Hi "+name+"\nGood Morning";
		else if(hour>12&&hour<=16)return "Hi "+name+"\nGood After Noon";
		else if(hour>=16&&hour<=20)return "Hi "+name+"\nGood Evening";
		else return "Hi "+name+"\nGood Night";
	}
}
