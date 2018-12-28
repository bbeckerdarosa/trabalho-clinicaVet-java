package br.com.clinicaVet.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private Map<String, String> errors;

	public ApiError(final HttpStatus status) {
		this.status = status;
		this.errors = new HashMap<>();
	}

	public ApiError(final HttpStatus status, final String field, final String error) {
		this.errors = new HashMap<>();
		this.status = status;
		addMessage(field, error);
	}

	public void addMessage(String field, String error) {
		this.errors.put(field, error);
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

}