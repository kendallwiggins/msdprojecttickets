package com.bah.msd.mcc.filter;

public interface JWTUtil {
	public boolean verifyToken(String jwt_token);
	public String getScopes(String jwt_token) ;
	public Token createToken() ;
}