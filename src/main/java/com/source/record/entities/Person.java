package com.source.record.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Person {
	
	private transient final String MOBILE_NUMBER_REGEX_PATTERN = "(0|\\\\+63)?[89][0-9]{9}";
	
	@Column(name = "firstname", nullable = false)
	@NotBlank(message = "{student.error.notblank.firstname}")
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	@NotBlank(message = "{student.error.notblank.lastname}")
	private String lastname;
	
	@Column(name = "middlename", nullable = false)
	@NotBlank(message = "{student.error.notblank.middlename}")
	private String middlename;
	
	@Embedded
	private Address address;
	
	@Column(name = "birthdate")
	@NotNull(message = "{student.error.notblank.birthdate}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(name = "status")
	@NotBlank(message = "{student.error.notblank.status}")
	private String status;
	
	@Column(name = "gender")
	@NotBlank(message = "{student.error.notblank.gender}")
	private String gender;
	
	@Column(name = "email")
	@NotBlank(message = "{student.error.notblank.email}")
	private String email;
	
	@Column(name = "mobile_number")
	@NotBlank(message = "{student.error.notblank.mobileNumber}")
	@Size(min = 11, max = 12, message = "{student.error.mobileNumber.size}")
	@Pattern(regexp = MOBILE_NUMBER_REGEX_PATTERN, message = "{student.error.mobileNumber.invalid}")
	private String mobileNumber;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
