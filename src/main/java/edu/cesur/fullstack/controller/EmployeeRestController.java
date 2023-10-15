package edu.cesur.fullstack.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.model.Employee;
import edu.cesur.fullstack.services.EmployeeService;
import edu.cesur.fullstack.validators.ValidCode;


@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	ArrayList<Employee> listaEmployees = new ArrayList<>(
			Arrays.asList(new Employee(1,"Miriam","miriam@gmail.com","EMP-dep-1234")
					,new Employee(2,"Elisa","elisa@gmail.com","EMP-dep-2345")
					,new Employee(3,"Fernando","fernando@gmail.com","EMP-dep-3456"))
			);
	
	EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;

	}
	@GetMapping
	public ResponseEntity<?> getPersonas() {
		ArrayList<Employee> listaEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(listaEmployees);
	}
	
	//GET
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		for (Employee p : listaEmployees) {
			if (p.getId() == id) {
			return ResponseEntity.ok(p);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//POST
	//crea nuevo Employee
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody @Validated(ValidCode.class) Employee employee) {
		Employee newEmployee = this.employeeService.saveEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
 
	//PUT
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody @Validated Employee employee) {
		for (Employee p : listaEmployees) {
			if (p.getId() == employee.getId()) {
				p.setName(employee.getName());
				p.setEmail(employee.getEmail());
				p.setEmployeeCode(employee.getEmployeeCode());

				return ResponseEntity.ok(p);
			}
		}

		return ResponseEntity.notFound().build();
	}

	
	//DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		for (Employee p : new ArrayList<>(listaEmployees)) {
			if (p.getId() == id) {
				listaEmployees.remove(p);
			    return ResponseEntity.noContent().build();
			}

		}

		return ResponseEntity.notFound().build();

	}
}
