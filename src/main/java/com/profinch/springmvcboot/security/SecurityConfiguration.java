package com.profinch.springmvcboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	public UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable().authorizeRequests()
			.antMatchers("http://localhost:8080/api/v1/managers").hasRole("MANAGER")
			.antMatchers("http://localhost:8080/api/v1/manager/addEmployee").hasRole("MANAGER")
			.antMatchers("http://localhost:8080/api/v1/manager/addAccountType").hasRole("MANAGER")
			.antMatchers("http://localhost:8080/api/v1/manager/employeesList").hasRole("MANAGER")
			.antMatchers("http://localhost:8080/api/v1/employee/createAccount").hasRole("EMPLOYEE")
			.antMatchers("http://localhost:8080/api/v1/allAccountTypes").hasAnyRole("MANAGER","EMPLOYEE")
			.antMatchers("http://localhost:8080/api/v1/manager").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	}
	
	
}
