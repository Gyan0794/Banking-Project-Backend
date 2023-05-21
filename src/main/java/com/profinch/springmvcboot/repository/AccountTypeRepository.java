package com.profinch.springmvcboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinch.springmvcboot.model.AccountType;
import com.profinch.springmvcboot.model.Employee;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
	AccountType findByAccountTypeName(String accountTypeName);
}
