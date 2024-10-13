/*
 * package com.bv.gms.security;
 * 
 * import jakarta.servlet.FilterChain; import jakarta.servlet.ServletException;
 * import jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import java.io.IOException;
 * 
 * @Component public class JwtRequestFilter extends OncePerRequestFilter {
 * 
 * 
 * private final JwtUtil jwtUtil;
 * 
 * @Autowired private final gmsu userDetailsService;
 * 
 * public JwtRequestFilter(JwtUtil jwtUtil, UserDetailsService
 * userDetailsService) { this.jwtUtil = jwtUtil; this.userDetailsService =
 * userDetailsService; }
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain) throws ServletException,
 * IOException { final String authorizationHeader =
 * request.getHeader("Authorization");
 * 
 * String username = null; String jwt = null;
 * 
 * if (authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
 * { jwt = authorizationHeader.substring(7); username =
 * jwtUtil.extractUsername(jwt); }
 * 
 * if (username != null &&
 * SecurityContextHolder.getContext().getAuthentication() == null) { var
 * userDetails = this.userDetailsService.loadUserByUsername(username);
 * 
 * if (jwtUtil.validateToken(jwt, userDetails)) { var authToken = new
 * UsernamePasswordAuthenticationToken(userDetails, null,
 * userDetails.getAuthorities());
 * SecurityContextHolder.getContext().setAuthentication(authToken); } }
 * 
 * chain.doFilter(request, response); } }
 * 
 * 
 */