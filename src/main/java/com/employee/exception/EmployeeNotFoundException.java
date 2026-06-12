package com.employee.exception;

public class EmployeeNotFoundException extends RuntimeException{
private String exceptionmsg;

public EmployeeNotFoundException(String exceptionmsg) {
	super();
	this.exceptionmsg = exceptionmsg;
}

public EmployeeNotFoundException() {
	super();
}

public String getExceptionmsg() {
	return exceptionmsg;
}

public void setExceptionmsg(String exceptionmsg) {
	this.exceptionmsg = exceptionmsg;
}

}
