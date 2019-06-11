package com.source.record.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.source.record.entities.Instructor;

@Repository
public interface InstructorRepository extends BaseRepository<Instructor, BigInteger> {

	@Query("SELECT i from Instructor i WHERE LOWER(i.lastname) LIKE %:lastname%")
	public List<Instructor> findInstructorsByLastname(@Param("lastname") String lastname);
}
