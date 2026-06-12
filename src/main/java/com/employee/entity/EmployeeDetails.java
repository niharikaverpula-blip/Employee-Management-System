package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class EmployeeDetails {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int empid;
private String empname;
private double empsalary;
private int empdeptno;
private String empemailid;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public double getEmpsalary() {
	return empsalary;
}
public void setEmpsalary(double empsalary) {
	this.empsalary = empsalary;
}
public int getEmpdeptno() {
	return empdeptno;
}
public void setEmpdeptno(int empdeptno) {
	this.empdeptno = empdeptno;
}
public String getEmpemailid() {
	return empemailid;
}
public void setEmpemailid(String empemailid) {
	this.empemailid = empemailid;
}
public EmployeeDetails(int empid, String empname, double empsalary, int empdeptno, String empemailid) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.empsalary = empsalary;
	this.empdeptno = empdeptno;
	this.empemailid = empemailid;
}
public EmployeeDetails() {
	super();
}
@Override
public String toString() {
	return "EmployeeDetails [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", empdeptno="
			+ empdeptno + ", empemailid=" + empemailid + "]";
}


}

