package com.profinch.springmvcboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profinch.springmvcboot.model.Employee;
import com.profinch.springmvcboot.model.Manager;
import com.profinch.springmvcboot.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController 
{		
		@Autowired
		EmployeeRepository employeeRepository;
		
		@GetMapping("/manager/employeesList")
		public List<Employee> getEmployees()
		{
			return (List<Employee>) employeeRepository.findAll();
		}
		
		@GetMapping("/manager/employee/{name}")
		public Employee getEmployee(@PathVariable("name") String name)
		{
			return (Employee) employeeRepository.findByName(name);
		}
		
		@PostMapping("/manager/addEmployee")
		void addEmployee(@RequestBody Employee employee)
		{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			
			employeeRepository.save(employee);
		}
}
