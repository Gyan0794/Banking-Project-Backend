package com.profinch.springmvcboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinch.springmvcboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByName(String name);
}
