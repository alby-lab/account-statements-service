package com.account.statement.config;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
		
	/**
	 * ____________________________________________________________________________________________
	 * 
	 * @author : Albert
	 * @MethodDesc : To authenticate user and route to the url
	 * @File : SecurityConfig.java
	 * @CreatedDate : JUN 16, 2021
	 * @ModifiedDate :
	 * @input :HttpSecurity
	 * @return : void
	 *         ______________________________________________________________________________________________
	 */
	@Override
	protected void configure(HttpSecurity http){
		try {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
		.csrf().requireCsrfProtectionMatcher(new DefaultRequiresCsrfMatcher());
		}catch (Exception e) {
			logger.error("SecurityConfig:configure:"+e.getMessage());
		}  
	}
	
	/**
	 * ____________________________________________________________________________________________
	 * 
	 * @author : Albert
	 * @MethodDesc : To verify the user name and password  
	 * @File : SecurityConfig.java
	 * @CreatedDate : JUN 16, 2021
	 * @ModifiedDate :
	 * @input :AuthenticationManagerBuilder
	 * @return : void
	 *         ______________________________________________________________________________________________
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		try {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("admin").password(encoder.encode("password")).roles("ADMIN")
		.and()
        .withUser("user")
        .password(encoder.encode("userpswd"))
        .roles("USER");
		}catch (Exception e) {
			logger.error("SecurityConfig:configureGlobal:"+e.getMessage());
		}	
	}
    public static final class DefaultRequiresCsrfMatcher implements RequestMatcher {
        
		@Override
		public boolean matches(HttpServletRequest request) {
		
			return false;
		}
    }
	


}
