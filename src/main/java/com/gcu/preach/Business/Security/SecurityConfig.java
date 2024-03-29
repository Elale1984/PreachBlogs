package com.gcu.preach.Business.Security;

import com.gcu.preach.Business.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserBusinessService service;

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/index/", "/register/**", "/images/**", "/css/**" ).permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/index/", true)
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/login/");
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(service)
			.passwordEncoder(passwordEncoder);


	}
	
}
