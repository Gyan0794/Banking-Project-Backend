package com.profinch.springmvcboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profinch.springmvcboot.model.AccountType;
import com.profinch.springmvcboot.repository.AccountTypeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AccountTypeController {

	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	@GetMapping("/allAccountTypes")
	public List<AccountType> getAccountTypes()
	{
		return (List<AccountType>) accountTypeRepository.findAll();
	}
	
	@GetMapping("/accountType/{name}")
	public AccountType getAccountType(@PathVariable("name") String name)
	{
		return (AccountType) accountTypeRepository.findByAccountTypeName(name);
	}
	
	@PostMapping("/manager/addAccountType")
	void addAccountType(@RequestBody AccountType accountType)
	{
		accountTypeRepository.save(accountType);
	}
	
}
