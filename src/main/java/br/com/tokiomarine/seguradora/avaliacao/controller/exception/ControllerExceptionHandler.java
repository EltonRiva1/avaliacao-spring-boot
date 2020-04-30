package br.com.tokiomarine.seguradora.avaliacao.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.tokiomarine.seguradora.avaliacao.service.exception.ObjectDoesNotExist;
import br.com.tokiomarine.seguradora.avaliacao.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<?> entity(ObjectNotFoundException exception) {
		LOGGER.info("Object not found");
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> entity(MethodArgumentNotValidException argumentNotValidException) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação!",
				System.currentTimeMillis());
		for (FieldError fieldError : argumentNotValidException.getBindingResult().getFieldErrors()) {
			error.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return ResponseEntity.badRequest().body(error);
	}

	@ExceptionHandler(ObjectDoesNotExist.class)
	public ResponseEntity<?> entity(ObjectDoesNotExist doesNotExist) {
		LOGGER.info("Object does not exist");
		return ResponseEntity.notFound().build();
	}
}
