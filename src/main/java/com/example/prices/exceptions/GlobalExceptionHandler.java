package com.example.prices.exceptions;

import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/** The constant logger for logging purposes. */
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public ErrorDTO handleServiceException(Exception exception, WebRequest request) {
		LOG.error(exception.getMessage(), exception);
		return ErrorDTO.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
				.message(MessageErrorCode.ERROR_UNEXPECTED.getDescription()).build();
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ PricesException.class })
	public ErrorDTO handleServiceException(PricesException exception, WebRequest request) {
		LOG.error(exception.getMessage(), exception);
		return ErrorDTO.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message(exception.getMessage())
				.build();
	}

}
