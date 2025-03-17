package com.hasnat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hasnat.entity.Doctor;
import com.hasnat.repository.IDoctorRepository;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    private IDoctorRepository docRepo;

    @Override
    public Page<Doctor> findAllByPagingAndSorting(int pageNo, int pageSize, boolean asc, String... props) {
        Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return docRepo.findAll(pageable);
    }
    
    
    
    @Override
    public void showDataThroughPagination(int pageSize) {
    	long count = docRepo.count();
    	long pageCount = count/pageSize;
    	if(count%pageCount!=0) pageCount++;
    	System.err.println(pageCount);
    	
    	for(int i=0;i<pageCount;++i) {
    		Pageable pageable = PageRequest.of(i, pageSize);
    		Page<Doctor> page = docRepo.findAll(pageable);
    		System.out.println("Page : "+(page.getNumber()+1)+"/"+page.getTotalPages());
    		page.getContent().forEach(System.out::println);
    		
    	}
    }
}
