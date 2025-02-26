package com.hasnat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.hasnat.sbeans.Vehical;

@SpringBootApplication
@ComponentScan("com.hasnat.sbeans") 
@ImportResource("com/hasnat/config/applicationContext.xml")

public class SpringBootProjectLayredApp2Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootProjectLayredApp2Application.class, args);
	
		Vehical vehical = ctx.getBean("vehical", Vehical.class);
		vehical.journey("Hyderabaad", "Kolkata");
		
	}

}