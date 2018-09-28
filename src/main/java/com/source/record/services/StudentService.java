package com.source.record.services;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.record.entities.Student;
import com.source.record.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public Student save(Student student) {
		String firstname = WordUtils.capitalizeFully(student.getFirstname());
		String middlename = WordUtils.capitalizeFully(student.getMiddlename());
		String lastname = WordUtils.capitalizeFully(student.getLastname());
		
		student.setFirstname(firstname);
		student.setMiddlename(middlename);
		student.setLastname(lastname);
		
		return studentRepo.save(student);
	}
	
	public Student findStudentByEmail(String email) {
		return studentRepo.findStudentByEmail(email);
	}
}
