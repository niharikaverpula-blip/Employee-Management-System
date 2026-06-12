package com.employee.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeDetails;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDAO {
	@Autowired
	private EmployeeRepository rep;
	
	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails)
	{
		return rep.save(employeeDetails);
		
	}
	
	public List<EmployeeDetails>selectAllEmployeeDetails()
	{
		return rep.findAll();
	}
	public EmployeeDetails selectEmployeeDetailsByUsingEmailid(String emailid)
	{
		return rep.findByEmpemailid(emailid);
		
	}
	public int deleteEmployeeDetailsByUsingEmailid(String emailid)
	{
		/*EmployeeDetails employeeDetails = rep.findByEmpemailid(emailid);
		if(employeeDetails!=null)
		{
			rep.delete(employeeDetails);
			return true;
		}
		else
		{
			return false;
		}*/
		return rep.removeByEmpemailid(emailid);
	}
	/*public updateEmployeesalaryByUsingEmpid(String empid)
	{
		return rep.saveAll(empid);*/
		
	}


