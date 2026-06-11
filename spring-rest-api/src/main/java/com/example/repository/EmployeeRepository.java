package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Employee;
import com.example.model.UpdateEmployeeRequest;

import lombok.experimental.var;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployee() {
		return employeeList;
	}

	public Employee getEmployeeById(String id) {

		Employee findEmployee = employeeList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
		;
		return findEmployee;
	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {

		if (firstName == null && lastName == null) {
			return employeeList;
		}

		return employeeList.stream()
				.filter(employee -> (firstName == null || firstName.equalsIgnoreCase(employee.getFirstName()))
						&& (lastName == null || lastName.equalsIgnoreCase(employee.getLastName())))
				.toList();
	}

	public Employee saveEmployee(Employee employee) {
		employeeList.add(employee);
		return employee;
	}

	public boolean deleteEmployee(String id) {
		Employee employee = getEmployeeById(id);
		if (employee != null) {
			employeeList.remove(employee);
			return true;
		}
		return false;
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest employee) {
		Employee findEmployee = getEmployeeById(id);
		if (employee != null) {
			findEmployee.setFirstName(employee.getFirstName());
			findEmployee.setLastName(employee.getLastName());
		}
		return findEmployee;
	}
}
