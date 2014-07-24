package com.dazzlersoft.webposutil;
import java.math.BigDecimal;
import java.text.DecimalFormat;


public class WebPosUtility {
	
	private static final String DECIMALFORMAT="#,###.00";

	public static final String formatNumber(BigDecimal number){
		DecimalFormat format=new DecimalFormat(DECIMALFORMAT);
		return format.format(number);
	}

}
