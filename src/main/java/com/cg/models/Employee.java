package com.cg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee {

	@Id
	@NotNull(message = "should not null")
	@Min(100000)
	@Max(999999)
	public int empId;
	@Column
	@NotEmpty(message = "name should not empty")
	@Pattern(regexp = "[A-Z][a-z]{2,}")
	private String fname;
	@Column
	@NotEmpty(message = "name should not empty")
	@Pattern(regexp = "[A-Z][a-z]{2,}")
	private String lname;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	private Date doj;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private Date dob;

	@Column
	private String department;

	@Column
	private String grade;
	@Column
	private String designation;
	@Column
	private String gender;
	@Column
	private Double salary;
	@Column
	private String maritalStatus;
	@Column
	private String address;
	@Column
	@NotNull(message = "should not null")
	@Min(100000)
	@Max(999999)
	private int managerId;
	
	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee() {
		super();
	}

	public Employee(int empId, String fname, String lname, Date doj, Date dob, String department, String grade,
			String designation, String gender, Double salary, String maritalStatus, String address, int managerId) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.doj = doj;
		this.dob = dob;
		this.department = department;
		this.grade = grade;
		this.designation = designation;
		this.gender = gender;
		this.salary = salary;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.managerId = managerId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}
