package com.source.record.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.record.entities.Subject;
import com.source.record.repositories.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;
	
	public Subject save(Subject subject) {
		return subjectRepo.save(subject);
	}
}
