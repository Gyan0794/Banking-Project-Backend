package com.profinch.springmvcboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profinch.springmvcboot.model.Account;
import com.profinch.springmvcboot.model.AccountType;
import com.profinch.springmvcboot.repository.AccountRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/account/{mobileNumber}")
	public Account getAccount(@PathVariable("mobileNumber") long mobileNumber)
	{
		return (Account) accountRepository.findByMobileNumber(mobileNumber);
	}

	@PostMapping("/employee/createAccount")
	void createAccount(@RequestBody Account account) {
		accountRepository.save(account);
	}
}
