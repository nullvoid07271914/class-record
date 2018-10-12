package com.source.record.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.source.record.entities.Instructor;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@RequestMapping("/registration")
	public String registration(Model model) {
		Instructor instructor = new Instructor();
		
		model.addAttribute("title", "Instructor Registry Panel");
		model.addAttribute("instructor", instructor);
		
		return "add_instructor";
	}
}
