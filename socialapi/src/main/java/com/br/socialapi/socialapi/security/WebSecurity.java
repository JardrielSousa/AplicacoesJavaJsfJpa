package com.br.socialapi.socialapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder aut) throws Exception {
		aut.inMemoryAuthentication().withUser("jardriel").password("{noop}1234").roles("root");
	}
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}
}
