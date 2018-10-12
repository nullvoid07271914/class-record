package com.source.record.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = { "/", "registration" }, method = RequestMethod.POST)
	public String registration(@Valid Instructor instructor, HttpServletRequest request, BindingResult bindingResult, Model model) {
		char[] password = request.getParameter("password").toCharArray();
		char[] passwordConfirm = request.getParameter("confirm_password").toCharArray();
		
		boolean passwordChecker = Arrays.equals(password, passwordConfirm);
		if (passwordChecker == false) {
			instructor.setPassword(null);
			bindingResult.rejectValue("password", "error.instructor", "Invalid password. Mismatched.");
		}
		
		if (bindingResult.hasErrors()) {
			return "add_instructor";
		}
		
		System.out.println(password);
		System.out.println(passwordConfirm);
		
		return "add_instructor";
	}
}
