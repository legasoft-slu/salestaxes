/**
 * 
 */
package com.lmgroup.salestaxes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lmgroup.salestaxes.entities.Taxes;

/**
 * @author Rafael León Gómez
 *
 */
public interface TaxRepository extends CrudRepository<Taxes, Long> {
	
}
