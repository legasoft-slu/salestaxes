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
@Table(name="PRODUCTTYPES", schema = "SALESTAXES")
public class ProductTypes {
	
	/**
	 * id attribute
	 */
	@Id
	@GeneratedValue
	private Long idProductType;
	
	/**
	 * type attribute
	 */
	private String name;
	
	/**
	 * tax attribute
	 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAX_ID")
	private Taxes tax;

//    @OneToMany(mappedBy = "PRODUCT_TYPE", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Products> products;

	/**
	 * @return the idProductType
	 */
	public Long getIdProductType() {
		return idProductType;
	}

	/**
	 * @param idProductType the idProductType to set
	 */
	public void setIdProductType(Long idProductType) {
		this.idProductType = idProductType;
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
	 * @return the tax
	 */
	public Taxes getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Taxes tax) {
		this.tax = tax;
	}

//	/**
//	 * @return the products
//	 */
//	public List<Products> getProducts() {
//		return products;
//	}
//
//	/**
//	 * @param products the products to set
//	 */
//	public void setProducts(List<Products> products) {
//		this.products = products;
//	}
    
}
