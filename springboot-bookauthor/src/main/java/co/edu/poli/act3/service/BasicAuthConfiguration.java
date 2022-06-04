package co.edu.poli.act3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {


	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
		inMemoryAuthentication().
		withUser("user1").
		password("{noop}123456").
		roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().
			disable().
			authorizeRequests().
			antMatchers("/api/v1/*").permitAll().
			antMatchers("/api/v1/UsuarioPersona/*").anonymous().
			anyRequest().
			authenticated().
			and().
			httpBasic();
	}
	

}