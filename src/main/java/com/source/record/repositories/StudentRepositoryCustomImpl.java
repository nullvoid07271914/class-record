package com.source.record.repositories;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.source.record.entities.Student;

@Repository
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

	private static Logger logger = LoggerFactory.getLogger(StudentRepositoryCustomImpl.class);

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public Student saveAndLog(Student student) {
		logger.info("Saving Student: " + student);
		System.out.println("Saving Student: " + student);
		entityManager.persist(student);
		
		return student;
	}
}
