package com.dazzlersoft.webpos.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211833098082987706L;
	
	private String productName;
	
	private String productDescription;
	
	private int quantityAvailable;
	
	private String color;
	private BigDecimal size;
	private String sizeMeasurement;
	
	public String getSizeMeasurement() {
		return sizeMeasurement;
	}

	public void setSizeMeasurement(String sizeMeasurement) {
		this.sizeMeasurement = sizeMeasurement;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	private String productPrice;
	
	private Long inventoryId;
	
	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

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
