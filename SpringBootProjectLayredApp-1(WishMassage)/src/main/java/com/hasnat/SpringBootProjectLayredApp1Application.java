package com.hasnat;

import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hasnat.sbeans.WishMassageGenerator;

@SpringBootApplication 
public class SpringBootProjectLayredApp1Application {
	
	 @Bean  // ✅ Register LocalTime as a Spring Bean
	    public LocalTime localTime() {
	        return LocalTime.now();
	    }

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SpringBootProjectLayredApp1Application.class, args);
		
		WishMassageGenerator wishMassageGenerator = ctx.getBean("wmg",WishMassageGenerator.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.next();
		String msg =wishMassageGenerator.generateMassage(name);
		System.out.println(msg);
		sc.close();
		
	}
	

}
