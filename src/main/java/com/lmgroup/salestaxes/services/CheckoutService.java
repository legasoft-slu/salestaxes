package com.lmgroup.salestaxes.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmgroup.salestaxes.entities.Item;
import com.lmgroup.salestaxes.entities.Products;
import com.lmgroup.salestaxes.entities.Receipt;
import com.lmgroup.salestaxes.entities.ShoppingBasket;

@Service
public class CheckoutService {
    
    private static final String TAX = "tax";
    private static final String PRICE = "price";
    private static final String ITEM = "item";
    
    @Autowired
	private ProductService productService;
	
	public String sellShoppingBasket (String text) {
		ShoppingBasket shoppingBasket = new ShoppingBasket(text);
		return sellShoppingBasket(shoppingBasket).printReceipt();
	}
    
	public Receipt sellShoppingBasket (ShoppingBasket shoppingBasket) {
		double taxes = 0.0;
		Receipt receipt = new Receipt();
		receipt.setItems(new ArrayList<Item>());
		for(Item item: shoppingBasket.getItems()) {
			Products product = productService.findByProductNameAndPrice(item.getProductName(), item.getPrice());
			HashMap<String, Object> result = getReceiptItem(product, item.getQuantity());
			Item receiptItem = (Item) result.get(ITEM);
			Double tax = (Double) result.get(TAX);
			taxes = ((int)(taxes * 100.0 + tax.doubleValue() * 100.0)) / 100.0;
			receipt.getItems().add(receiptItem);
		}
		double totalPrice = getReceiptTotalPrice(receipt.getItems());
		receipt.setTotal(totalPrice);
		receipt.setSalesTaxes(taxes);
		return receipt;
	}
	
	private HashMap<String, Object> getReceiptItem(final Products product, final Float quantity) {
		Item item = new Item();
		HashMap<String, Object> result = new HashMap<>();
		item.setProductName(product.getName());
		item.setQuantity(quantity);
		HashMap<String, Double> finalPrice = getFinalPrice(product);
		Double price = finalPrice.get(PRICE) * quantity.doubleValue();
		Double tax = finalPrice.get(TAX);
		item.setPrice(price);
		result.put(ITEM, item);
		result.put(TAX, tax);
		return result;
	}
	
	private double getReceiptTotalPrice(List<Item> items) {
		double result = 0.0;
		for (Item item : items) {
			result = (result * 100.0 + item.getPrice() * 100.0) / 100.0;
		}
		return result;
	}
	
	private HashMap<String, Double> getFinalPrice(final Products product) {
		HashMap<String, Double> result = new HashMap<>();
		float rate = product.getType().getTax().getRate() / 100;
		double price = product.getPrice();
		double taxPrice = price * rate;
		double roundedTaxPrice = getRoundedTaxPrice(taxPrice);
		double finalPrice = ((int)(price * 100.0 + roundedTaxPrice * 100.0)) / 100.0;
		double finalTax = (roundedTaxPrice * 100.0) / 100.0;
		result.put(TAX, Double.valueOf(finalTax));
		result.put(PRICE, Double.valueOf(finalPrice));
		return result;
	}
	
	private double getRoundedTaxPrice(final double taxPrice) {
		double newPriceTax = ((int)(taxPrice * 1000.0)) / 1000.0;
		int cen = ((int)(newPriceTax * 10)) * 100;
		int mil = (int)(newPriceTax * 1000);
		int referenceToRound = mil - cen;
		
		if (referenceToRound >= 51 && referenceToRound <= 99) {
			newPriceTax = (cen + 100.0) / 1000.0;
		} else if (referenceToRound >= 1 && referenceToRound <= 49) {
			newPriceTax = (cen + 50.0) / 1000.0;
		}
		return newPriceTax;
	}
	
}
