package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.UpdateEmployeeRequest;
import com.example.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/list")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping(path = "/list/{id}")
	public Employee getEmployeeById(@PathVariable(required = true) String id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping(path = "/with-param")
	public List<Employee> getEmployeeWithParams(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName) {
		return employeeService.getEmployeeWithParams(firstName, lastName);
	}

	@PostMapping(path = "/save-employee")
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		return employeeService.saveEmployee(newEmployee);
	}

	@DeleteMapping(path = "/delete-employee/{id}")
	public boolean deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping(path = "update-employee/{id}")
	public Employee updateEmployee(@PathVariable String id,@RequestBody UpdateEmployeeRequest employee) {
		return employeeService.updateEmployee(id,employee);
	}

}
