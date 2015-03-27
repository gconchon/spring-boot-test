package net.emcheris.spboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebMvcSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties security;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		      .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/plugins/**").permitAll()
		      .anyRequest().fullyAuthenticated()
		      .and()
		    .formLogin()
		      .loginPage("/login").failureUrl("/login?error").permitAll()
		      .and()
		    .logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		      .withUser("admin").password("admin").roles("ADMIN", "USER").and()
		      .withUser("user").password("user").roles("USER");
	}

}
