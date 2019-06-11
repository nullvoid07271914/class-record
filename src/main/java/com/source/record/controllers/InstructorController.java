package com.source.record.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.source.record.entities.Instructor;
import com.source.record.services.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping(value = "/request/by-lastname.do", method = RequestMethod.POST)
	public @ResponseBody List<Instructor> findInstructorsByLastname(@RequestParam("instructor_lastname") String lastname) {
		List<Instructor> instructors = instructorService.findInstructorsByLastname(lastname);
		System.out.println("instructors: " + instructors);
		return instructors;
	}
}
