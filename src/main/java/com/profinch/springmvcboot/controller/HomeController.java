package com.profinch.springmvcboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profinch.springmvcboot.repository.ForLogin;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class HomeController {

	@GetMapping("/login")
	public ForLogin login() {
		
		return new ForLogin("Message from backend.");
	}
	
}
