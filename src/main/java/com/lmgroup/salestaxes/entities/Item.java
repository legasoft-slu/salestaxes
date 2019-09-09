/**
 * 
 */
package com.lmgroup.salestaxes.entities;

import java.io.Serializable;

/**
 * @author Rafael León Gómez
 *
 */
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2171696755234156331L;

	/**
	 * product name attribute
	 */
	private String productName;
	
	/**
	 * quantity attribute
	 */
	private float quantity;
	
	/**
	 * price attribute
	 */
	private double price;
	
	public Item () {

	}
	
	public Item(final String text) {
		int beginQuantityIndex = 0;
		int endQuantityIndex = text.indexOf(" ");
		float quantityAux = Float.parseFloat(text.substring(beginQuantityIndex, endQuantityIndex));
		int beginProductNameIndex = endQuantityIndex + 1;
		int endProductNameIndex = text.indexOf(" at ");
		String productNameAux = text.substring(beginProductNameIndex, endProductNameIndex);
		int beginPriceIndex = endProductNameIndex +  + " at ".length();
		int endPriceIndex = text.length();
		double priceAux = Double.parseDouble(text.substring(beginPriceIndex, endPriceIndex));
		this.productName = productNameAux;
		this.quantity = quantityAux;
		this.price = priceAux;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(final String productName) {
		this.productName = productName;
	}

	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(final float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(final double price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + Float.floatToIntBits(quantity);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.equals(other.productName)) {
			return false;
		}
		if (Float.floatToIntBits(quantity) != Float.floatToIntBits(other.quantity)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
