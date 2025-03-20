package com.hasnat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hasnat.entity.Doctor;

import jakarta.transaction.Transactional;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	
	//@Query("FROM Doctor doc where doc.income>=? AND doc.income<=?")//Throws the IllegalArgumentException
	//@Query("FROM Doctor doc where doc.income>=?1 AND doc.income<=?2")
	//@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM com.hasnat.entity.Doctor WHERE income>=?1 AND income<=?2")
	//@Query("SELECT doc FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")

	//public List<Doctor> findAllDoctorByIncomeRange(Integer min,Integer max);
	
	@Query("FROM Doctor  WHERE income >= :min AND income <= :max")
	List<Doctor> findAllDoctorByIncomeRange(@Param("min") Integer min, @Param("max") Integer max);
	
	@Query("FROM Doctor  WHERE specialization in(:sp1,:sp2)ORDER BY specialization")
	public List<Doctor> findAllDoctorBySpecialization(@Param("sp1") String sp1, @Param("sp2") String sp2);
	
	@Query("SELECT name FROM Doctor  WHERE income >= :min AND income <= :max")
	List<String> findAllDoctorNameByIncomeRange(@Param("min") Integer min, @Param("max") Integer max);
	
	@Query("SELECT name,specialization FROM Doctor  WHERE income >= :min AND income <= :max")
	List<Object> findAllDoctorNameAndSpecializationByIncomeRange(@Param("min") Integer min, @Param("max") Integer max);
	
	@Query("SELECT count (distinct name) FROM Doctor")//repeated name will not count
	public Integer getNoOfDoctor();
	
	@Query("SELECT count(*), max(income), min(income), avg(income), sum(income) FROM Doctor")
	public Object fetchAggregateData();
	
	@Query("UPDATE Doctor SET income=income+(income*:percentage/100) WHERE specialization=:sp")
	@Modifying
	@Transactional
	public Integer hikeDoctorIncomeBySpecialization(@Param("sp") String sp, @Param("percentage") Integer percentage);
	
	@Query("DELETE FROM Doctor WHERE income=:sal")
	@Modifying
	@Transactional
	public Integer deleteDocterBySalaryRange(@Param("sal") Integer sal);
	
	/*
	@Query(value="INSERT INTO doctor111 (name, specialization, income) VALUES (:name, :specialization, :income)", nativeQuery= true)
	@Modifying
	@Transactional
	public int registerDoctor(@Param("name") String name, @Param("specialization") String special, @Param("income") Integer income);
	
	*/
	
	@Query(value = "SELECT SYSDATE()", nativeQuery = true)
	public String showSystemDate();



	
	  @Modifying
	  @Transactional
	  @Query(value = "CREATE TABLE IF NOT EXISTS temp (col1 VARCHAR(20))", nativeQuery = true)
	  public Integer createTable();

}
