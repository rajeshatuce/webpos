package com.dazzlersoft.webposutil;

public class WebPosGenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2872169460481019640L;
	
	public WebPosGenericException(String msg,Exception err){
		super(msg, err);
	}

}
