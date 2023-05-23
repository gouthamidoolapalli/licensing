package com.benchmark.licensing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class UserForm{

	@Id
	@Column
	@NotBlank
	private String userId;
	@Column
	@NotBlank
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
	@NotBlank
	private boolean marketingCommunication;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolContactNo() {
		return schoolContactNo;
	}
	public void setSchoolContactNo(String schoolContactNo) {
		this.schoolContactNo = schoolContactNo;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMarketingInfo() {
		return marketingInfo;
	}
	public void setMarketingInfo(String marketingInfo) {
		this.marketingInfo = marketingInfo;
	}
	public String getFreeTrailStartDate() {
		return freeTrailStartDate;
	}
	public void setFreeTrailStartDate(String freeTrailStartDate) {
		this.freeTrailStartDate = freeTrailStartDate;
	}
	public String getOrganisationType() {
		return organisationType;
	}
	public void setOrganisationType(String organisationType) {
		this.organisationType = organisationType;
	}
	public String getEducatorCount() {
		return educatorCount;
	}
	public void setEducatorCount(String educatorCount) {
		this.educatorCount = educatorCount;
	}
	public boolean isMarketingCommunication() {
		return marketingCommunication;
	}
	public void setMarketingCommunication(boolean marketingCommunication) {
		this.marketingCommunication = marketingCommunication;
	}
}
