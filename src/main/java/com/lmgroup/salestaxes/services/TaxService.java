/**
 * 
 */
package com.lmgroup.salestaxes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmgroup.salestaxes.entities.Taxes;
import com.lmgroup.salestaxes.repositories.TaxRepository;

/**
 * @author Rafael León Gómez
 *
 */
@Service
public class TaxService {
	
    @Autowired
    TaxRepository taxRepository;

	public Taxes create(final Taxes tax) {
		return taxRepository.save(tax);
	}
	
	public List<Taxes> findAll () {
		return (List<Taxes>) taxRepository.findAll();
	}

	public Optional<Taxes> findById(final Long id) {
		return taxRepository.findById(id);
	}
	
	public Taxes update(final Taxes tax) {
		return taxRepository.save(tax);
	}
	
	public void deleteById(final Long id) {
		taxRepository.deleteById(id);
	}
	
}
