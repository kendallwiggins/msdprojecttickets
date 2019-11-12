package com.bah.msd.mcc.controller;

import com.bah.msd.mcc.domain.Token;

public interface JWTUtil {
	public boolean verifyToken(String jwt_token);
	public String getScopes(String jwt_token) ;
	public Token createToken(String scopes) ;
}