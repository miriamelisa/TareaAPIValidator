package edu.cesur.fullstack.services;

import java.util.ArrayList;

import edu.cesur.fullstack.model.Employee;

public interface EmployeeService {
	
	public ArrayList<Employee> getAllEmployees();
	
	public Employee saveEmployee(Employee employee);

}
