package com.GestionStock.app.jwt.resource;
public class AuthenticationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 111131150969742338L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

