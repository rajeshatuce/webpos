package com.dazzlersoft.webpos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductPriceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 390578847031899280L;
	
	private List<Product> productList;
	
	private BigDecimal totalPrice;
	
	private String formattedTotalPrice;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getFormattedTotalPrice() {
		return formattedTotalPrice;
	}

	public void setFormattedTotalPrice(String formattedTotalPrice) {
		this.formattedTotalPrice = formattedTotalPrice;
	}

}
