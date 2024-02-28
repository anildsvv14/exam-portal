package com.examportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.examportal.security.JwtAuthenticationEntryPoint;
import com.examportal.security.JwtAuthenticationFilter;
import com.examportal.service.impl.UserDetailServiceImpl;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	 @Autowired
	    private JwtAuthenticationEntryPoint point;
	    @Autowired
	    private JwtAuthenticationFilter filter;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	       /* http.csrf(csrf -> csrf.disable())
	                .authorizeRequests().
	                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll()
	                .anyRequest()
	                .authenticated()
	                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();*/
	    	
           
	    	
	    	http.csrf(csrf->csrf.disable())
	    	.cors(cors->cors.disable())
	    	.authorizeHttpRequests(auth->auth
	    	.requestMatchers("/user/**").authenticated()
	    	//.requestMatchers("/user/**").authenticated()
	    	.requestMatchers("/auth/login").permitAll()
	    	.requestMatchers("/auth/register").permitAll()
	    	
	    	.requestMatchers("/auth/current-user").authenticated()
	    	//.requestMatchers("/user/**").authenticated()
	    	.anyRequest().authenticated())
	    	.exceptionHandling(ex->ex.authenticationEntryPoint(point))
	    	.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	    	
	    	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
	    	http.cors();
	    	return http.build();
	    }
	
}
