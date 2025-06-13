package com.hasnat.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name="callerTuneInfo111")
public class CallerTuneInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(length=30)
	private String tuneName;
	@Version
	@Column(name="UpdateCount")
	private Integer updateCount;
	@Column(name="serviceOptedOn, updateable=false")
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	
	@Column(name="lastlyUpdateOn, insertable= false")
	@UpdateTimestamp
	private LocalDateTime lastlyUpdateOn;
	
}
