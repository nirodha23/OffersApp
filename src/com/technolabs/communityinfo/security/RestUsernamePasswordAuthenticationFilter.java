package com.technolabs.communityinfo.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Authentication filter for REST services
 */
public class RestUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		boolean retVal = false;
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		System.out.println("In RestUsernamePasswordAuthenticationFilter");
		System.out.println("username :"+username);
		System.out.println("password :"+password);
		
		Enumeration enum1 = request.getParameterNames();
		while(enum1.hasMoreElements()){
			System.out.println(enum1.nextElement());
		}

		if (username != null && password != null) {
			Authentication authResult = null;
			try {
				System.out.println("Before attemptAuthentication()");
				authResult = attemptAuthentication(request, response);
				System.out.println("isAuthenticated() "+authResult.isAuthenticated());
				if (authResult == null) {
					System.out.println("Is Null "+authResult);
					retVal = false;
				}
			} catch (AuthenticationException failed) {
				try {
					unsuccessfulAuthentication(request, response, failed);
				} catch (IOException e) {
					retVal = false;
				} catch (ServletException e) {
					retVal = false;
				}
				retVal = false;
			} catch(Exception e){
				System.out.println("In catch");
				e.printStackTrace();
			}
			if(authResult != null && authResult.isAuthenticated()){
			try {
				successfulAuthentication(request, response, authResult);
			} catch (IOException e) {
				retVal = false;
			} catch (ServletException e) {
				retVal = false;
			}
		}
			return false;
		} else {
			retVal = true;
		}
		return retVal;
	}
}
