package com.source.record.repositories;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.source.record.entities.Student;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long>, StudentRepositoryCustom {

	public Optional<Student> findStudentByEmail(@Param("email") String email);
	
	public Optional<Student> findStudentByMobileNumber(@Param("mobileNumber") String mobileNumber);
	
	//@Query(nativeQuery = true)
	//public Optional<Student> findStudentByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
