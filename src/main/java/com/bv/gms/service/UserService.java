package com.bv.gms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bv.gms.dto.LoginDto;
import com.bv.gms.entities.User;
import com.bv.gms.repositories.UserRepository;
import com.bv.gms.security.GmsUserDetailsService;
import com.bv.gms.security.JwtUtil;

import java.util.Optional;

@Service
public class UserService {
    
	@Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private GmsUserDetailsService userDetailsService;

	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @Autowired
    private JwtUtil jwtUtil;


    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public String authenticateAndGenerateToken(LoginDto loginDto) throws Exception {
        
    	System.out.println("user controlller");
    	
    	// Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUserId(), loginDto.getPassword())
        );
    	

        // Load the user
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUserId());
        
        System.out.println("user details");
        
        // Generate the JWT token
        return jwtUtil.generateToken(userDetails);
    }

    // Other user-related methods
}
