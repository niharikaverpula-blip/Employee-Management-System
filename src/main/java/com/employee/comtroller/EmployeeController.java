package com.employee.comtroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeDetails;
import com.employee.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
//@Controller
public class EmployeeController {
	/*It is used to create the end point for insert operation*/
	@Autowired
	EmployeeService employeeService;
	
@PostMapping("/registration") /*which is used to create the Endpoint*/
 public ResponseEntity<EmployeeDetails> insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails)
{
	return employeeService.employeeRegistation(employeeDetails);
}
//@ResponseBody
/*It is used to create the end point for selection operation*/
@GetMapping("/selectemployeedetails")
 public ResponseEntity<EmployeeDetails> selectEmployee(@RequestParam("useremailid") String emailid)
{
	System.out.println(emailid);
	return employeeService.getEmployeeByUsingEmailid1(emailid);	
}
/**It is used to create the end point for update operation*/
@PutMapping("/updateEmployee")
public String updateEmployeeDetails()
{
	return "Data Updated...";
}
/*It is used to create the end point for delete operation*/
@DeleteMapping("/deleteEmployee/{emailid}")
public ResponseEntity<String>deleteEmployeeDetails(@PathVariable("emailid")String useremailid)
{
	System.out.println(useremailid);
	return employeeService.deleteEmployeeDetailsByUsingEmailid(useremailid);
	
}
}


/*Query String declaration the keys and values with the URL
 * localhost:8080/customerlogin?key=value & key=value & key=value
 * @RequestParam is used to get the values from Query String
 * 
 * path Param declaring direct values in the URL
 * localhost:8080/customerlogin/value/value
 * 
 * But while creating the end point we need to create the keys
 * 
 * Syntax:
 * @GetMapping("/customerlogin/{key}/{key}")
 * 
 * @PathVariable is used to get the Values From the Path param
 */

