package com.hasnat.configurationProperties;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component("configBean")
@Data
@ConfigurationProperties(prefix="user")
public class DemoConfigurationProperties {
	private String name;
	private String city;
	private Integer pin;
	private Long phno;
	private Integer abc;//It will print  null because in properties file abc is not there
	
	public String getUser() {
		return "Name :"+name+" City "+city+" Pin :"+pin+" Ph no. :"+phno+" abc :"+abc;
	}
	
	List<String> servers ;
	Set<String> uniqueServers;
	Map<String,String> database;
    List<String> citys;
    
    Map<String,String> idDetails;
}
