package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.DAO.EmployeeDAO;
import com.employee.config.EmailConfig;
import com.employee.entity.EmployeeDetails;
import com.employee.exception.EmployeeDataValidationException;
import com.employee.exception.EmployeeNotFoundException;

@Service
public class EmployeeService 
{
	@Autowired
	EmailConfig emailConfig;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	
	public ResponseEntity<EmployeeDetails> employeeRegistation(EmployeeDetails employeeDetails)
	{
		List<EmployeeDetails>allEmployeeDetails=employeeDAO.selectAllEmployeeDetails();
		long emailidcount = allEmployeeDetails.stream().filter((employee)->employee.getEmpemailid().equals(employeeDetails.getEmpemailid())).count();
		if(emailidcount==0)
		{
			EmployeeDetails details = employeeDAO.insertEmployeeDetails(employeeDetails);
			if(details.getEmpid()!=0)
			{
				emailConfig.sendTextMsg(details.getEmpemailid(),details.getEmpname()+"Your account created successfully..");
				return new ResponseEntity<EmployeeDetails>(details,HttpStatus.OK);
			}

		else
		{
			return new ResponseEntity<EmployeeDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
		else {
			throw new EmployeeDataValidationException("Emailid Already Existed....");
		}

	}
	public ResponseEntity<EmployeeDetails> getEmployeeByUsingEmailid1(String emailid)
	{
		EmployeeDetails employeeDetails = employeeDAO.selectEmployeeDetailsByUsingEmailid(emailid);
		if(employeeDetails!=null)
		{
			return new ResponseEntity<EmployeeDetails>(employeeDetails,HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotFoundException("No Data Found");
		}
	}
	public ResponseEntity<String> deleteEmployeeDetailsByUsingEmailid(String useremailid) {
		if(employeeDAO.deleteEmployeeDetailsByUsingEmailid(useremailid)!=0)
		{
			return new ResponseEntity<String>(useremailid,HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotFoundException("No Data Found");
		}
	}
	/*public ResponseEntity<String> updateEmployeesalaryByUsingEmpid(String empid)
		{
			if(employeeDAO.updateEmployeesalaryByUsingEmpid(empid)!=0)
			{
				return new ResponseEntity<String>(empid,HttpStatus.OK);
			}
			else
			{
				throw new EmployeeNotFoundException("updated..");*/
}
	
		
	

