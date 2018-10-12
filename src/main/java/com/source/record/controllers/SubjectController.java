package com.source.record.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.source.record.entities.Student;
import com.source.record.entities.Subject;
import com.source.record.services.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = "/adding", method = RequestMethod.GET)
	public String addSubject(Model model) {
		Subject subject = new Subject();
		List<Student> instructors = subjectService.findAllInstructor();
		System.out.println(instructors);
		
		model.addAttribute("subject", subject);
		model.addAttribute("instructors", instructors);
		
		return "add_subject";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute @Valid Subject subject, Model model, BindingResult bindingResult) {
		System.out.println(subject);
		if (bindingResult.hasErrors()) {
			return "add_subject";
		}
		
//		subjectService.save(subject);
//		Subject newSubject = new Subject();
//		model.addAttribute("subject", newSubject);
		
		return "add_subject";
	}
}
