/**
 * 
 */
package com.lmgroup.salestaxes.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lmgroup.salestaxes.entities.Products;

/**
 * @author Rafael León Gómez
 *
 */
public interface ProductRepository extends CrudRepository<Products, Long> {

	@Query("SELECT p, pt, t FROM Products p, ProductTypes pt, Taxes t INNER JOIN Taxes ON pt.id = p.type.id WHERE p.name = ?1 and p.price = ?2")
	List<Products> findByProductNameAndPrice(final String name, final Double price);
	
}
