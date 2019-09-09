/**
 * 
 */
package com.lmgroup.salestaxes.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Rafael León Gómez
 *
 */
@Entity
@Table(name="PRODUCTS", schema = "SALESTAXES")
public class Products {

	/**
	 * id attribute
	 */
	@Id
	@GeneratedValue
	private Long idProduct;
	
	/**
	 * type attribute
	 */
	private String name;
	
	/**
	 * type attribute
	 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_TYPE_ID")
	private ProductTypes type;
	
	/**
	 * price attribute
	 */
	private Double price;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return idProduct;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public ProductTypes getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ProductTypes type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}
