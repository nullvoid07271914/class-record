package com.source.record.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_tbl")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private BigInteger roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "instructor_id", nullable = false)
//	private Instructor instructor;
	
	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	public Instructor getInstructor() {
//		return instructor;
//	}
//
//	public void setInstructor(Instructor instructor) {
//		this.instructor = instructor;
//	}
}
