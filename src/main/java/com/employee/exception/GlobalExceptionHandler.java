package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(EmployeeDataValidationException.class)
public ResponseEntity<String>userRelatedException(EmployeeDataValidationException empDataValidationException)
{
System.out.println("user related exception");
String exception=empDataValidationException.getExceptionmsg();
return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<String> employeeNotFoundRelatedException() {
	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

}
}
