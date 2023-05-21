package com.profinch.springmvcboot.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.profinch.springmvcboot.model.Manager;

public class ManagerUserDetailsImplementation implements UserDetails {
	
	private Manager manager;

	public ManagerUserDetailsImplementation(Manager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.singleton(new SimpleGrantedAuthority(this.manager.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return manager.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return manager.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
