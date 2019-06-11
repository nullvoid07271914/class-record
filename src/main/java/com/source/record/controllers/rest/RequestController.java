package com.source.record.controllers.rest;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.source.record.controllers.rest.requestbody.InstructorWrapper;
import com.source.record.controllers.rest.response.AjaxResponseBody;
import com.source.record.entities.Instructor;
import com.source.record.security.utils.SecurityAuthenticationUtils;
import com.source.record.services.InstructorService;

@RestController
@RequestMapping("/ajax")
public class RequestController {

	@Autowired
	private InstructorService instructorService;

	//@Secured({ "hasRole('ROLE_ADMIN')" })
	@PostMapping(value = "/request/instructor/by-lastname.do",
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> findInstructorsByLastname(@Valid @RequestBody InstructorWrapper instructor, HttpSession session) {
		AjaxResponseBody<Instructor> responseResult = new AjaxResponseBody<>();

		List<Instructor> instructors = null;
		boolean isAuthenticated = SecurityAuthenticationUtils.isCurrentUserAuthenticated();
		if (isAuthenticated) {
			instructors = instructorService.findInstructorsByLastname(instructor.getLastname());
			if (instructors.isEmpty()) {
				responseResult.setMessage("No instructor can be found.");
			} else {
				session.setAttribute("instructors", instructors);
				responseResult.setMessage("Instructor(s) found.");
			}
			responseResult.setResult(instructors);
		}

		return ResponseEntity.ok(responseResult);
	}
}
