package com.source.record.controllers.rest.response;

import java.util.List;

public class AjaxResponseBody<T> {

	private String message;
	
	private List<T> result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
