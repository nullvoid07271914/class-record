package com.source.record.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.source.record.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
