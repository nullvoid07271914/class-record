package com.source.record.entities.auditable.listener;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.source.record.entities.Student;
import com.source.record.entities.StudentHistory;
import com.source.record.entities.auditable.AuditableAction;
import com.source.record.services.beans.BeanUtil;

public class StudentEntityListener {

	@PrePersist
	public void prePersist(Student targetStudent) {
		actionPerformed(targetStudent, AuditableAction.INSERTED);
	}

	@PreUpdate
	public void preUpdate(Student targetStudent) {
		actionPerformed(targetStudent, AuditableAction.UPDATED);
	}

	@PreRemove
	public void preRemove(Student targetStudent) {
		actionPerformed(targetStudent, AuditableAction.DELETED);
	}

    @Transactional(propagation = Propagation.MANDATORY)
    private void actionPerformed(Student targetStudent, AuditableAction action) {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        StudentHistory studentHistory = new StudentHistory(targetStudent, action);
        entityManager.persist(studentHistory);
    }
}
