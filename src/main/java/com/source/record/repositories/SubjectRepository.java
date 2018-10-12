package com.source.record.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.source.record.entities.Student;
import com.source.record.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	@Query("SELECT s.firstname from Student s")
	public List<Student> findAllInstructor();
}
