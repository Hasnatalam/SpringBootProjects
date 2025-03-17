package com.hasnat.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.hasnat.controller.IDoctorController;
import com.hasnat.entity.Doctor;

@Component
public class CrudDataJpaApplicationRunner implements CommandLineRunner {
	@Autowired
	private IDoctorController docController;

	@Override
	public void run(String... args) throws Exception {
		Page<Doctor> allByPagingAndSorting = docController.findAllByPagingAndSorting(0, 10, true, "name");
		try {
			String msg = allByPagingAndSorting.isFirst()?"first":allByPagingAndSorting.isLast()?"Last":"Not first or last ";
			System.out.println("This is "+msg+" page");
			System.out.println("Size of the page is "+allByPagingAndSorting.getSize());
			System.out.println("No of total page is "+allByPagingAndSorting.getTotalPages());
			System.out.println("Page no "+(allByPagingAndSorting.getNumber()+1));
		if(!allByPagingAndSorting.isEmpty()) {
		 List<Doctor> content = allByPagingAndSorting.getContent();
		 content.forEach(System.out::println);}
		else
			System.out.println("Page not found");
		
		docController.showDataThroughPagination(5);
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	

}
