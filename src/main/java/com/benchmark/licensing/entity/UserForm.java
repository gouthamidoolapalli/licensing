package com.benchmark.licensing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
public class UserForm{

	@Id
	@Column
	private int userId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String districtName;
	
	@Column
	private String role;
	
	@Column
	private String schoolName;
	
	@Column
	private String schoolContactNo;
	
	@Column
	private String zipCode;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String address;
	
	@Column
	private String marketingInfo;
	
	@Column
	private String freeTrailStartDate;
	
	@Column
	private String organisationType;
	
	@Column
	private String educatorCount;
	
	@Column
	private boolean marketingCommunication;
	
}
