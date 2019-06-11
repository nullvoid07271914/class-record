package com.source.record.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.source.record.entities.Student;
import com.source.record.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	//@Transactional
	public Student save(Student student) {
		String firstname = WordUtils.capitalizeFully(student.getFirstname());
		String middlename = WordUtils.capitalizeFully(student.getMiddlename());
		String lastname = WordUtils.capitalizeFully(student.getLastname());

		student.setFirstname(firstname);
		student.setMiddlename(middlename);
		student.setLastname(lastname);

		String encodedPassword = passwordEncoding(student.getPassword());
		student.setPassword(encodedPassword);

		return studentRepo.save(student);
	}

	/* Custom Implementation */
	//@Transactional
	public Student saveAndLog(Student student) {
		return studentRepo.saveAndLog(student);
	}

	@Transactional(readOnly = true)
	public List<Student> findByIds(Long... ids) {
		return studentRepo.findByIds(ids);
	}

	@Transactional(readOnly = true)
	public Optional<Student> findStudentByEmail(String email) {
		return studentRepo.findStudentByEmail(email);
	}

	@Transactional(readOnly = true)
	public Optional<Student> findStudentByMobileNumber(String mobileNumber) {
		return studentRepo.findStudentByMobileNumber(mobileNumber);
	}

	private String passwordEncoding(String password) {
		return password;
	}
}
