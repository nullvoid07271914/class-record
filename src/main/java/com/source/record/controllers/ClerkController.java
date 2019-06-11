package com.source.record.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/clerk")
public class ClerkController {

	@RequestMapping(value = "/student/adding/subjects", method = RequestMethod.GET)
	public String addStudentSubjects(Model model) {
		
		return "add_student_subjects";
	}
}
