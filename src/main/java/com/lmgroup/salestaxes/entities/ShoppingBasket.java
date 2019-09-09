/**
 * 
 */
package com.lmgroup.salestaxes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rafael León Gómez
 *
 */
public class ShoppingBasket implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8061255523097246956L;
	
	/**
	 * product name attribute
	 */
	private ArrayList<Item> items;
	
	public ShoppingBasket(String text) {
		String[] itemsText = text.split("\n");
		ArrayList<Item> itemsAux = new ArrayList<>();
		for(String itemText : itemsText) {
			Item item = new Item(itemText);
			itemsAux.add(item);
		}
		items = itemsAux;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(final List<Item> items) {
		this.items = (ArrayList<Item>) items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		if (!(obj instanceof ShoppingBasket)) {
			return false;
		}
		ShoppingBasket other = (ShoppingBasket) obj;
		if (items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!items.equals(other.items)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShoppingBasket [items=" + items + "]";
	}


}
