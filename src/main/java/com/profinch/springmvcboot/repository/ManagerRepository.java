package com.profinch.springmvcboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinch.springmvcboot.model.Employee;
import com.profinch.springmvcboot.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

	Manager findByName(String name);
}
