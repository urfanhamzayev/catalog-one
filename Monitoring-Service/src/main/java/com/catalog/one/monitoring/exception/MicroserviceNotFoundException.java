package com.catalog.one.monitoring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MicroserviceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2077540900444926856L;
	
}
