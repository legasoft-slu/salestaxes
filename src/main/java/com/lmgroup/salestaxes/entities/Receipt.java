/**
 * 
 */
package com.lmgroup.salestaxes.entities;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * @author Rafael León Gómez
 *
 */
public class Receipt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4937120890336660461L;
	
	/**
	 * product name attribute
	 */
	private ArrayList<Item> items;

	/**
	 * total attribute
	 */
	private double total;
	
	/**
	 * sales taxes attribute
	 */
	private double salesTaxes;
	

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}
	
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the salesTaxes
	 */
	public double getSalesTaxes() {
		return salesTaxes;
	}

	/**
	 * @param salesTaxes the salesTaxes to set
	 */
	public void setSalesTaxes(double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(final List<Item> items) {
		this.items = (ArrayList<Item>) items;
	}
	
	/**
	 * @return the receipt JSON object
	 */
	public JSONObject toJSON() {
		String jsonInString = new Gson().toJson(this);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonInString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * @return the receipt String object
	 */
	public String printReceipt() {
		StringBuilder result = new StringBuilder();
		NumberFormat formatter = new DecimalFormat("#0.00");
		for (Item item : getItems()) {
			result.append(Integer.toString(Float.valueOf(item.getQuantity()).intValue()) + " ");
			result.append(item.getProductName() + ": ");     
			result.append(formatter.format(item.getPrice()).replace(',', '.')  + "\n");
		}
		result.append("Sales Taxes: " + formatter.format(getSalesTaxes()).replace(',', '.') + "\n");
		result.append("Total: " + formatter.format(getTotal()).replace(',', '.'));
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salesTaxes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof Receipt)) {
			return false;
		}
		Receipt other = (Receipt) obj;
		if (items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!items.equals(other.items)) {
			return false;
		}
		if (Double.doubleToLongBits(salesTaxes) != Double.doubleToLongBits(other.salesTaxes)) {
			return false;
		}
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Receipt [items=" + items + ", total=" + total + ", salesTaxes=" + salesTaxes + "]";
	}

}
