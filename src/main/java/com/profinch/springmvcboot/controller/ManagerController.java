package com.profinch.springmvcboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.profinch.springmvcboot.model.Manager;
import com.profinch.springmvcboot.repository.ManagerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ManagerController 
{
	private Manager manager;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@GetMapping("/managers")
	public List<Manager> getManagers()
	{

		return (List<Manager>) managerRepository.findAll();
	}
	
	@GetMapping("/manager/{name}")
	public Manager getManager(@PathVariable("name") String name)
	{
		this.manager = managerRepository.findByName(name);
		if(this.manager != null) {
			return this.manager;
		} else {
			return null;
		}
	}
	
	@PostMapping("/manager")
	void addManager(@RequestBody Manager manager)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		manager.setPassword(passwordEncoder.encode(manager.getPassword()));
		managerRepository.save(manager);
	}
}
