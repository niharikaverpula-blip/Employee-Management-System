package com.employee.exception;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class EmployeeDataValidationException extends RuntimeException {
	private String exceptionmsg;

	public String getExceptionmsg() {
		return exceptionmsg;
	}

	public void setExceptionmsg(String exceptionmsg) {
		this.exceptionmsg = exceptionmsg;
	}

	public EmployeeDataValidationException(String exceptionmsg) {
		super();
		this.exceptionmsg = exceptionmsg;
	}

	public EmployeeDataValidationException() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeDataValidationException [exceptionmsg=" + exceptionmsg + "]";
	}
	
	

}
