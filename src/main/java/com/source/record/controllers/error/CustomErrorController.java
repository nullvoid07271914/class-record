//package com.source.record.controllers.error;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//@RestController
//public class CustomErrorController implements ErrorController {
//
//	@GetMapping(value = "/error/access", produces = "text/html")
//	public ModelAndView renderErrorPage(HttpServletRequest request, Exception exception) {
//		exception.getLocalizedMessage();
//		Map<String, Object> errors = getErrorAttributes(request, errorAttributes);
//		errors.forEach((key, value) -> {
//			System.out.println(key + " -> " + String.valueOf(value));
//		});
//		return new ModelAndView("error_page.html", errors);
//	}
//
//	@PostMapping(value = "/error/access")
//	public Map<String, Object> error(HttpServletRequest request, ErrorAttributes errorAttributes) {
//		Map<String, Object> errors = getErrorAttributes(request, errorAttributes);
//		errors.forEach((key, value) -> {
//			System.out.println(key + " -> " + String.valueOf(value));
//		});
//		return errors;
//	}
//
//	public Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributes errorAttributes) {
//		WebRequest webRequest = new ServletWebRequest(request);
//		return errorAttributes.getErrorAttributes(webRequest, false);
//	}
//
//	@Override
//	public String getErrorPath() {
//		return "/error/access";
//	}
//}
