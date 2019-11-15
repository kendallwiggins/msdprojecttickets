package com.bah.msd.mcc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthFilter implements Filter {

	//JWTUtil jwtUtil = new JWTMockUtil();
	JWTUtil jwtUtil = new JWTHelper();
	
	private String api_scope = "scope";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		System.out.println(uri);
		if ( uri.startsWith("/api/customers")
				|| uri.startsWith("/api/registrations") 
						|| uri.startsWith("/api/events")) 			
			{
			// continue on to get-token endpoint
			System.out.println("Checking this!!!!! " + uri);
			chain.doFilter(request, response);
			return;
			
		} else {
			// check JWT token
			System.out.println("Get to create token?");
			String authheader = req.getHeader("authorization");
			if (authheader != null && authheader.length() > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				System.out.println("Test help" + jwt_token);
				
				if (jwtUtil.verifyToken(jwt_token)) {
					String request_scopes = jwtUtil.getScopes(jwt_token);
					if (request_scopes.contains(api_scope)) {
						// continue on to api
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}

		// reject request and return error instead of data
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");
	}

}
