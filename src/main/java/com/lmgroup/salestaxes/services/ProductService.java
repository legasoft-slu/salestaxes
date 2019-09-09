/**
 * 
 */
package com.lmgroup.salestaxes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmgroup.salestaxes.entities.Products;
import com.lmgroup.salestaxes.repositories.ProductRepository;

/**
 * @author Rafael León Gómez
 *
 */
@Service
public class ProductService {
	
    @Autowired
    ProductRepository productRepository;

	public Products create(final Products product) {
		return productRepository.save(product);
	}
	
	public List<Products> findAll () {
		return (List<Products>) productRepository.findAll();
	}

	public Optional<Products> findById(final Long id) {
		return productRepository.findById(id);
	}
	
	public Products findByProductNameAndPrice(final String name, final Double price) {
		List<Products> products = productRepository.findByProductNameAndPrice(name, price);
		return products.get(0);
	}
	
	public Products update(final Products product) {
		return productRepository.save(product);
	}
	
	public void deleteById(final Long id) {
		productRepository.deleteById(id);
	}
	
}
