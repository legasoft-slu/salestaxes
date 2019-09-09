package com.lmgroup.salestaxes.utils;

import com.google.gson.Gson;
import com.lmgroup.salestaxes.entities.Products;
import com.lmgroup.salestaxes.entities.ProductTypes;
import com.lmgroup.salestaxes.entities.ShoppingBasket;
import com.lmgroup.salestaxes.entities.Taxes;

public class TransformationUtil {
	
	private TransformationUtil() {}

	public static ShoppingBasket fromJsonToShoppingBasket(final String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, ShoppingBasket.class);
	}
	
	public static Products fromJsonToProduct(final String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Products.class);		
	}
	
	public static ProductTypes fromJsonToProductType(final String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, ProductTypes.class);		
	}
	
	public static Taxes fromJsonToTax(final String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Taxes.class);		
	}

}
