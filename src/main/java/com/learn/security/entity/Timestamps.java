package com.learn.security.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
@Data
public class Timestamps {

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
	
	private Date modifiedOn;

	private String createdBy;
	
	private String modifiedBy;


}
