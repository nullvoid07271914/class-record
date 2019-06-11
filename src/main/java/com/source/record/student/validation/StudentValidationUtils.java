package com.source.record.student.validation;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.source.record.entities.Student;
import com.source.record.services.StudentService;

@Component
public class StudentValidationUtils implements Validator {

	private static final String EMAIL_REGEX_PATTERN = "[a-zA-Z][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+";

	@Autowired
	private StudentService studentService;

	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		boolean studentExists = validateStudentExists(errors, student);
		if (!studentExists){
			String email = student.getEmail();
			if (!email.isEmpty()) {
				validateEmail(errors, email);
			}
		}
	}

	private boolean validateStudentExists(Errors errors, Student student) {
		String email = student.getEmail();
		String mobileNumber = student.getMobileNumber();
		
		Optional<Student> checkEmail = studentService.findStudentByEmail(email);
		Optional<Student> checkMobileNumber = studentService.findStudentByMobileNumber(mobileNumber);
		
		if (checkEmail.isPresent()) {
			errors.rejectValue("email", "student.error.email.exists");
		}
		
		if (checkMobileNumber.isPresent()) {
			errors.rejectValue("mobileNumber", "student.error.mobileNumber.exists");
		}
		
		if (checkEmail.isPresent() || checkMobileNumber.isPresent())
			return true;
		
		return false;
	}
	
	private void validateEmail(Errors errors, String email) {
		Pattern emailPattern = Pattern.compile(EMAIL_REGEX_PATTERN);
		Matcher match = emailPattern.matcher(email);
		if (!match.find()) {
			errors.rejectValue("email", "student.error.email.invalid");
		}
	}
}
