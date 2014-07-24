package com.dazzlersoft.webpos.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211833098082987706L;
	
	private String productName;
	
	private String productPrice;
	
	private String productImageUrl;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	

}
