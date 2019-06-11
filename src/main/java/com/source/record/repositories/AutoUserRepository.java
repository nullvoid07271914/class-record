package com.source.record.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.source.record.entities.Student;

@Repository
public interface AutoUserRepository extends JpaRepository<Student, Long>{

}
