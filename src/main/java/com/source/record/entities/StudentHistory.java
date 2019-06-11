package com.source.record.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.source.record.entities.auditable.Auditable;
import com.source.record.entities.auditable.AuditableAction;

@Entity(name = "student_history_tbl")
@EntityListeners(AuditingEntityListener.class)
public class StudentHistory extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_history_id")
	private Long studentHistoryId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "audit_action")
	private AuditableAction auditAction;
	
	@ManyToOne
	@JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_student_history_student"))
	private Student student;
	
	public StudentHistory(Student student, AuditableAction auditAction) {
		this.student = student;
		this.auditAction = auditAction;
	}

	public Long getStudentHistoryId() {
		return studentHistoryId;
	}

	public void setStudentHistoryId(Long studentHistoryId) {
		this.studentHistoryId = studentHistoryId;
	}

	public AuditableAction getAuditAction() {
		return auditAction;
	}

	public void setAuditAction(AuditableAction auditAction) {
		this.auditAction = auditAction;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
