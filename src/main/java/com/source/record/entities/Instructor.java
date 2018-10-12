package com.source.record.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_tbl")
public class Instructor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long instructorId;
	
	@Column(name = "password", nullable = false)
	private char[] password;

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.toCharArray();
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", password=" + Arrays.toString(password)
				+ ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getMiddlename()="
				+ getMiddlename() + ", getBlock()=" + getBlock() + ", getStreet()=" + getStreet() + ", getBarangay()="
				+ getBarangay() + ", getCity()=" + getCity() + ", getZipcode()=" + getZipcode() + ", getBirthdate()="
				+ getBirthdate() + ", getStatus()=" + getStatus() + ", getGender()=" + getGender() + ", getEmail()="
				+ getEmail() + ", getMobileNumber()=" + getMobileNumber() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
