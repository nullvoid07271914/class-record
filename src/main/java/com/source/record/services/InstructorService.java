package com.source.record.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.record.entities.Instructor;
import com.source.record.repositories.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	public List<Instructor> findInstructorsByLastname(String lastname) {
		String lastnameLowerCase = lastname.toLowerCase();
		return instructorRepository.findInstructorsByLastname(lastnameLowerCase);
	}
}
