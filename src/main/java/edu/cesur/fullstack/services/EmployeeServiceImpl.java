package edu.cesur.fullstack.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Primary;

import edu.cesur.fullstack.model.Employee;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Primary
public class EmployeeServiceImpl implements EmployeeService {

	ArrayList<Employee> listaEmployees = new ArrayList<>(
			Arrays.asList(new Employee(1,"Miriam","miriam@gmail.com","EMP-dep-1234")
					,new Employee(2,"Elisa","elisa@gmail.com","EMP-dep-2345")
					,new Employee(3,"Fernando","fernando@gmail.com","EMP-dep-3456"))
			);
	
	@Override
	public Employee saveEmployee(Employee employee) {
		this.listaEmployees.add(employee);
		return employee;
		
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return listaEmployees;
	}
	
}
