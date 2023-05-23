package com.benchmark.licensing.model;

public class LicensingInfo {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String districtName;
	private String role;
	private String schoolName;
	private String schoolContactNo;
	private String zipCode;
	private String city;
	private String state;
	private String address;
	private String marketingInfo;
	private String freeTrailStartDate;
	private String organisationType;
	private String educatorCount;
	private boolean marketingCommunication;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "LicensingInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", districtName=" + districtName + ", role=" + role + ", schoolName=" + schoolName
				+ ", schoolContactNo=" + schoolContactNo + ", zipCode=" + zipCode + ", city=" + city + ", state="
				+ state + ", address=" + address + ", marketingInfo=" + marketingInfo + ", freeTrailStartDate="
				+ freeTrailStartDate + ", organisationType=" + organisationType + ", educatorCount=" + educatorCount
				+ ", marketingCommunication=" + marketingCommunication + "]";
	}
	
	

}
