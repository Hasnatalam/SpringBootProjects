package com.hasnat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasnat.entity.CallerTuneInfo;

public interface ICallerTuneRepository extends JpaRepository<CallerTuneInfo, Integer>{

}
