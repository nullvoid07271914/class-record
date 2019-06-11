package com.source.record.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.source.record.entities.Address;
import com.source.record.entities.Student;
import com.source.record.services.StudentService;
import com.source.record.student.validation.StudentValidationUtils;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentValidationUtils validator;

	@RequestMapping(value = { "/", "/registration" }, method = RequestMethod.GET)
	public String registration(Model model) {
		Student student = new Student();
		student.setAddress(new Address());
		model.addAttribute("student", student);
		
		List<Student> students = studentService.findByIds(1L, 2L);
		System.out.println(students);
		
		return "add_student";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String registration(@ModelAttribute @Valid Student student, BindingResult bindingResult, Model model, SessionStatus status) {
		validator.validate(student, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "add_student";
		}

		//studentService.save(student);		/* standard spring data persisting */
		studentService.saveAndLog(student);	/* custom implementation */
		
		Student newStudent = new Student();
		newStudent.setAddress(new Address());
		model.addAttribute("student", newStudent);
		model.addAttribute("message", "Student successfully registered.");
		
		/* authecated after added */
		Authentication auth = new UsernamePasswordAuthenticationToken(student, "NullVoid", student.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		status.setComplete();	/* Mark Session Complete */
		return "add_student";
	}
}
