package com.profinch.springmvcboot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private long accountNumber;
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	private long mobileNumber;
	private String accountType;
	private long balance;
	
	public Account() {}
	
	public Account(long id, long accountNumber, String name, Date dateOfBirth, long mobileNumber, String accountType,
			long balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	

}
