/**
 * 
 */
package com.lmgroup.salestaxes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rafael León Gómez
 *
 */
@Entity
@Table(name="TAXES", schema = "SALESTAXES")
public class Taxes {
	
	/**
	 * id attribute
	 */
	@Id
	@GeneratedValue
	private Long idTax;
	
	/**
	 * type attribute
	 */
	private String name;
	
	/**
	 * rate attribute
	 */
	private Float rate;
	
//    @OneToMany(mappedBy = "TAXES", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<ProductTypes> productTypes;

	/**
	 * @return the idTax
	 */
	public Long getIdTax() {
		return idTax;
	}

	/**
	 * @param idTax the idTax to set
	 */
	public void setIdTax(Long idTax) {
		this.idTax = idTax;
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
	 * @return the rate
	 */
	public Float getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(Float rate) {
		this.rate = rate;
	}

//	/**
//	 * @return the productTypes
//	 */
//	public List<ProductTypes> getProductTypes() {
//		return productTypes;
//	}
//
//	/**
//	 * @param productTypes the productTypes to set
//	 */
//	public void setProductTypes(List<ProductTypes> productTypes) {
//		this.productTypes = productTypes;
//	}

}
