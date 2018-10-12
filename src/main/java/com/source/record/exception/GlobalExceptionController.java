package com.source.record.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@ExceptionHandler({Exception.class})
	public String customGenericExceptionHandler(Model model, Exception e) {
		model.addAttribute("status", "");
		model.addAttribute("message", e.getMessage());
		
		return "error_page";
	}
}
