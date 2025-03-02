package com.hasnat.configurationProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("demoBean")
@Data
public class DemoValue {
    
    @Value("${user.name}") // Fetch from properties file
    private String name;

    @Value("#{'${user.city}'.split(',')}") // Fetch from properties file
    private String []city;

    @Value("${user.pin}") 
    private Integer pin;

    @Value("${user.phno}") // Fetch from properties file
    private Long phno;
    
    @Value("${user.basicSalary}")
    private double salary;
    
    @Value("10000")
    private double bonus;
    
    @Value("#{${user.basicSalary}-${user.epf}}")//Spel
    private double inHand;
    
    @Value("#{20 + 30}") // Injecting calculated value
    private int sum;

    @Value("#{T(java.lang.Math).random() * 100}") // Injecting random number
    private double randomValue;
    
    @Value("#{${user.active} ? 'Application is active' : 'Application is inactive'}")//Spel
    private String appStatus;
    
}
