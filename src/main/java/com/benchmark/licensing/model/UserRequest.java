package com.benchmark.licensing.model;

import com.benchmark.licensing.utils.annotations.ContactNumber;
import com.benchmark.licensing.utils.annotations.FreeTrialDate;
import com.benchmark.licensing.utils.annotations.OrganisationType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

	@NotBlank
	private String userId;
	
	@NotBlank(message = "First name cannot be null")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be null")
	private String lastName;
	
	@Email(message="Email isn't valid")
	private String email;
	
	@NotBlank(message = "District name cannot be null")
	private String districtName;
	
	@NotBlank(message = "role cannot be null")
	private String role;
	
	@NotBlank(message = "School name cannot be null")
	private String schoolName;
	
	@ContactNumber
	private String schoolContactNo;
	
	@Size(min = 5, max = 5, message = "Zip code must be 5 digits")
	private String zipCode;
	
	@NotBlank(message = "City cannot be null")
	private String city;
	
	@NotBlank(message = "State cannot be null")
	private String state;
	
	@NotBlank
	@Size(min=3, max = 20, message = "Adress must be in 50-100 range of charcters")
	private String address;
	
	@NotBlank(message = "Marketing Info cannot be null")
	private String marketingInfo;
	
	@FreeTrialDate
	private String freeTrailStartDate;
	
	@OrganisationType
	private String organisationType;
	
	@NotBlank(message = "educator count cannot be null")
	private String educatorCount;
	
	private boolean marketingCommunication;

}
