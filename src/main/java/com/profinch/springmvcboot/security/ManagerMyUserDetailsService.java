package com.profinch.springmvcboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.profinch.springmvcboot.model.Employee;
import com.profinch.springmvcboot.model.Manager;
import com.profinch.springmvcboot.repository.EmployeeRepository;
import com.profinch.springmvcboot.repository.ManagerRepository;

@Service
public class ManagerMyUserDetailsService implements UserDetailsService {
	
	private UserDetails user;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Manager manager = managerRepository.findByName(name);
		
		Employee employee = employeeRepository.findByName(name);
		
		if(manager != null)
		{
			return new ManagerUserDetailsImplementation(manager);
			
		} else if(employee != null) {
			
			return new UserDetailsImplementation(employee);
		} 
		
		return user;
	}
	

}
