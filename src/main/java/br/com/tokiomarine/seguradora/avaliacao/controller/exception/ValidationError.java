package br.com.tokiomarine.seguradora.avaliacao.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FieldMessage> fieldMessages = new ArrayList<>();

	public ValidationError(Integer status, String message, Long timestamp) {
		super(status, message, timestamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getFieldMessages() {
		return fieldMessages;
	}

	public void addError(String fieldName, String message) {
		this.fieldMessages.add(new FieldMessage(fieldName, message));
	}
}
