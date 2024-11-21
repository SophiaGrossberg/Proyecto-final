package com.example.product.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.global.dto.MessageDto;
import com.example.product.global.exceptions.AttributeException;
import com.example.product.global.exceptions.ResourceNotFoundException;

public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
		  String customMessage = "Recurso no encontrado" + e.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new MessageDto(HttpStatus.NOT_FOUND, customMessage));
	}
	@ExceptionHandler(AttributeException.class)
	public ResponseEntity<MessageDto>throwAttributeException(AttributeException e){
		
		return ResponseEntity.badRequest()
				.body(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()));
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDto>generalException(Exception e){
		
		return ResponseEntity.internalServerError()
				.body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
	}
}
