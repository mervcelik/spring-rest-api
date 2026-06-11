package com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList=new ArrayList<>();
		
		employeeList.add(new Employee("1","Merve","Çelik"));
		employeeList.add(new Employee("2","Adem","Çelik"));
		employeeList.add(new Employee("3","Ayşe","Gürsoy"));
		employeeList.add(new Employee("4","Fatma","Yılmaz"));
		employeeList.add(new Employee("5","Hatice","Öztürk"));
		
		return employeeList;
	}
}
