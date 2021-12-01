package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN")
		.and()
		.withUser("operator").password("{noop}operator").roles("OPERATOR");
		
	}
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new UrlAuthenticationSuccessHandler();
	}
	
	@Override
    protected void configure(final HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        .antMatchers("/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .and()
        .formLogin()
            .loginProcessingUrl("/login")
            .successHandler(myAuthenticationSuccessHandler());
    
    http.csrf().disable();
    http.headers().frameOptions().disable();         
    }
	
}
