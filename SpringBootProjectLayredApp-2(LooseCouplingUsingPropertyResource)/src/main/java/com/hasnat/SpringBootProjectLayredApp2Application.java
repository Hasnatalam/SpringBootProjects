package com.hasnat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.hasnat.sbeans.Vehical;

@SpringBootApplication
public class SpringBootProjectLayredApp2Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootProjectLayredApp2Application.class, args);
	
		Vehical vehical = ctx.getBean("vehical", Vehical.class);
		vehical.journey("Hyderabaad", "Kolkata");
		
	}

}