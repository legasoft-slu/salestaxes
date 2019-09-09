/**
 * 
 */
package com.lmgroup.salestaxes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmgroup.salestaxes.entities.ProductTypes;
import com.lmgroup.salestaxes.repositories.ProductTypeRepository;

/**
 * @author Rafael León Gómez
 *
 */
@Service
public class ProductTypeService {
	
    @Autowired
    ProductTypeRepository productTypeRepository;

	public ProductTypes create(final ProductTypes productType) {
		return productTypeRepository.save(productType);
	}
	
	public List<ProductTypes> findAll () {
		return (List<ProductTypes>) productTypeRepository.findAll();
	}

	public Optional<ProductTypes> findById(final Long id) {
		return productTypeRepository.findById(id);
	}
	
	public ProductTypes update(final ProductTypes productType) {
		return productTypeRepository.save(productType);
	}
	
	public void deleteById(final Long id) {
		productTypeRepository.deleteById(id);
	}
	
}
