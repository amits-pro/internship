package com.bv.gms.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
	private GmsUserDetailsService userDetailsService;

    @Autowired
	private PasswordEncoder passwordEncoder;
	
	    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("register", "login").permitAll()  // Allow public access
                .anyRequest().authenticated()
            );

        return http.build();
    }


    
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
    	
    	System.out.println("authentication manager");
    	 var authProvider = new DaoAuthenticationProvider();
         authProvider.setUserDetailsService(userDetailsService);
         authProvider.setPasswordEncoder(passwordEncoder);
         return new ProviderManager(authProvider);    }
}
