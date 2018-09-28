package com.source.record.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.source.record.entities.Student;
import com.source.record.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = { "/", "/registration" }, method = RequestMethod.GET)
	public String registration(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_student";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String registration(@ModelAttribute @Valid Student student, BindingResult bindingResult, Model model) {
		String email = student.getEmail();
		Student checkStudent = studentService.findStudentByEmail(email);
		
		if (checkStudent != null) {	
			bindingResult.rejectValue("email", "error.student", "There is already a user registered with the email provided.");
		}
		
		if (bindingResult.hasErrors()) {
			return "add_student";
		}

		studentService.save(student);
		
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);
		model.addAttribute("message", "successfully registered.");

		return "add_student";
	}
}
