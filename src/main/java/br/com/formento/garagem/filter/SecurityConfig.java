package br.com.formento.garagem.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.formento.garagem.service.GaragemUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
//	@Qualifier("garagemUserDetailsService")
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
//	GaragemUserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		FormLoginConfigurer<HttpSecurity> formLogin = httpSecurity.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest()
				.authenticated().and().formLogin();
		formLogin = formLogin.loginPage("/loginPage").permitAll();
		formLogin = formLogin.defaultSuccessUrl("/garagemCadastro");
		formLogin = formLogin.usernameParameter("username");
		formLogin = formLogin.usernameParameter("username");

		LogoutConfigurer<HttpSecurity> formLogout = formLogin.and().logout().permitAll();
		formLogout.logoutSuccessUrl("/loginPage");

		formLogout.and().httpBasic();

	}

//	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
