package com.vinit.angularspringboot.security;


import static com.vinit.angularspringboot.security.SecurityConstants.EXPIRATION_TIME;
import static com.vinit.angularspringboot.security.SecurityConstants.HEADER_STRING;
import static com.vinit.angularspringboot.security.SecurityConstants.SECRET;
import static com.vinit.angularspringboot.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinit.angularspringboot.domainObjects.UserProfile;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		// TODO Auto-generated constructor stub
		this.authenticationManager = authenticationManager;
	}
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
        	HashMap<String,String> creds = new ObjectMapper()
                    .readValue(req.getInputStream(),  new TypeReference<HashMap<String, String>>(){});

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.get("userName"),
                            creds.get("password"),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	@Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm. HS512, SECRET.getBytes())
                .compact();
        
        res.addHeader("access-control-expose-headers", "Authorization");
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }

}
