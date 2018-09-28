package com.source.record.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class Person {

	@Column(name = "firstname", nullable = false)
	@NotBlank(message = "Enter your firstname.")
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	@NotBlank(message = "Enter your lastname.")
	private String lastname;
	
	@Column(name = "middlename", nullable = false)
	@NotBlank(message = "Enter your middlename.")
	private String middlename;
	
	@Column(name = "address_block")
	private String block;
	
	@Column(name = "address_street")
	private String street;
	
	@Column(name = "address_barangay")
	private String barangay;
	
	@Column(name = "address_city")
	private String city;
	
	@Column(name = "address_zipcode")
	private String zipcode;
	
	@Column(name = "birthdate")
	@NotNull(message = "Enter your birthdate.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(name = "status")
	@NotBlank(message = "Enter your status.")
	private String status;
	
	@Column(name = "gender")
	@NotBlank(message = "Enter your gender.")
	private String gender;
	
	@Column(name = "email")
	@NotBlank(message = "Email cannot be empty.")
	@Pattern(regexp = "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+", message = "Enter a valid email.")
	private String email;
	
	@Column(name = "mobile_number")
	@NotBlank(message = "Enter your mobile number.")
	@Pattern(regexp = "(0|\\+63)?[89][0-9]{9}", message = "Invalid mobile number format.")
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

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
