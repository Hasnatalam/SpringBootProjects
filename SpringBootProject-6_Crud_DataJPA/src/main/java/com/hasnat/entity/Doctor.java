package com.hasnat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Doctor111")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "Id")
	private Integer id;
	@Column(name= "Name")
	private String name;
	@Column(name= "Specialization")
	private String specialization;
	@Column(name= "Income")
	private double income;
	
	 public Doctor(String name, String specialization, double income) {
	        this.name = name;
	        this.specialization = specialization;
	        this.income = income;
	    }
	
}
