package com.profinch.springmvcboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountType 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String accountTypeName;
	private int minimumBalance;
	
	public AccountType() {}
	
	public AccountType(long id, String accountTypeName, int minimumBalance) {
		super();
		this.id = id;
		this.accountTypeName = accountTypeName;
		this.minimumBalance = minimumBalance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	public int getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", accountTypeName=" + accountTypeName + ", minimumBalance=" + minimumBalance
				+ "]";
	}
	
	
}
