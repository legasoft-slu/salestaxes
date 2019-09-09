package com.lmgroup.salestaxes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lmgroup.salestaxes.entities.ProductTypes;

/**
 * @author Rafael León Gómez
 *
 */
public interface ProductTypeRepository extends CrudRepository<ProductTypes, Long> {
	
}
