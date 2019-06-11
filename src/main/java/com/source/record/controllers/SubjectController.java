package com.source.record.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.source.record.entities.Instructor;
import com.source.record.entities.Subject;
import com.source.record.services.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/adding.htm", method = RequestMethod.GET)
	public String addSubject(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentLoggedUser = (UserDetails) authentication.getPrincipal();
		Collection<? extends GrantedAuthority> currentAuthorities = currentLoggedUser.getAuthorities();
		System.out.println("currentAuthorities: " + currentAuthorities);
		
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "add_subject";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute @Valid Subject subject, Model model, BindingResult bindingResult,
			HttpSession session, WebRequest webRequest) {

		List<Instructor> instructors = (List<Instructor>) session.getAttribute("instructors");
		System.out.println(instructors);
		// get list of instructor by %name%
		//session.setAttribute("subject", subject);
		//if (AjaxUtils.isAjaxRequest(webRequest)) {
			// prepare model for rendering success message in this request
			//model.addAttribute("ajaxRequest", true);
			//model.addAttribute("subject", subject);
		//}

		// Authentication authentication =
		// SecurityContextHolder.getContext().getAuthentication();
		// if (authentication != null) {
		// boolean isAnonymous = authentication instanceof AnonymousAuthenticationToken;
		// if (authentication.isAuthenticated() && !isAnonymous) {
		// subjectService.save(subject);
		// Subject newSubject = new Subject();
		// model.addAttribute("subject", newSubject);
		// model.addAttribute("message", "Subject successfully registered.");
		// }
		// } else {
		 Subject newSubject = new Subject();
		 model.addAttribute("subject", newSubject);
		// model.addAttribute("message", "Unauthorized personnel.");
		// }

		return "add_subject";
	}
}


//$("#Customer").submit(function() {  
//    $.post($(this).attr("action"), $(this).serialize(), function(html) {
//        $("#customerdiv").replaceWith(html);
//
//    });
//    return false;  
//});
