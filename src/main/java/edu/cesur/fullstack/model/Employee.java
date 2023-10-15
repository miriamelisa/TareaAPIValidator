package edu.cesur.fullstack.model;

import edu.cesur.fullstack.validators.CodeValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Employee {
	@Min(value=0, message="no admite números negativos")
	private int id;
	@NotBlank
	private String name;
	@Email(message = "Email should be valid")
	private String email;
	@CodeValidation
	private String employeeCode;
	//"EMP-dep-1234", donde "dep" debería ser reemplazado por las 3 primeras letras del nombre del departamento.
	
	public Employee(int id, String name, String email, String employeeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeCode = employeeCode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", employeeCode=" + employeeCode + "]";
	}
	
	
	
}
