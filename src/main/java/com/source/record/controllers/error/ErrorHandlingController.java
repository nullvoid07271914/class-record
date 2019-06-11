package com.source.record.controllers.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorHandlingController {
	
	private static Logger logger = LoggerFactory.getLogger(ErrorHandlingController.class);

	@RequestMapping("/access")
	public String renderErrorPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		int httpStatusCode = response.getStatus();
		HttpStatus httpStatus = HttpStatus.valueOf(httpStatusCode);
		String httpStatusDescription = httpStatus.getReasonPhrase();
		
		logger.info("ErrorHandlingController -> renderErrorPage -> httpStatusCode: " + httpStatusCode);
		logger.info("ErrorHandlingController -> renderErrorPage -> httpStatusDescription: " + httpStatusDescription);
		
		model.addAttribute("httpStatusCode", httpStatusCode);
		model.addAttribute("httpStatusDescription", httpStatusDescription);
		
		return "error_page";
	}
}
