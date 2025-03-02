package com.hasnat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hasnat.configurationProperties.DemoConfigurationProperties;
import com.hasnat.configurationProperties.DemoValue;

@SpringBootApplication
public class ClientDemoApp {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(ClientDemoApp.class, args);
		DemoValue bean = ctx.getBean("demoBean",DemoValue.class);
		System.out.println(bean);
		System.out.println();
		
		ApplicationContext ctx1= SpringApplication.run(ClientDemoApp.class, args);
		DemoConfigurationProperties bean1 = ctx1.getBean("configBean",DemoConfigurationProperties.class);
		
		System.out.println(bean1.getUser());
		System.out.println(bean1.getServers());
		System.out.println(bean1.getUniqueServers());
		System.out.println(bean1.getDatabase());
		System.out.println(bean1.getCitys());
		System.out.println(bean1.getIdDetails());
	}
	
	

}
