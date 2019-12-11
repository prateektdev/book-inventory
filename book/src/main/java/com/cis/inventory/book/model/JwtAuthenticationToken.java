package com.cis.inventory.book.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**

* The class is the model for the jwt token which We are generation from the token filter.

* @version 1.0

* @author CIS

*/
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
