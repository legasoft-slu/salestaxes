package com.lmgroup.salestaxes.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmgroup.salestaxes.entities.Taxes;
import com.lmgroup.salestaxes.services.TaxService;
import com.lmgroup.salestaxes.utils.TransformationUtil;


@Controller
public class TaxController {
	
	protected TaxService taxService;

	//constructor
	public TaxController(TaxService taxService) {
		this.taxService = taxService;
	}
	
	@RequestMapping(path="/api/taxes/", method=RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> createTax(@RequestBody String json) {
		Taxes tax = TransformationUtil.fromJsonToTax(json);
		taxService.create(tax);
	    return new ResponseEntity<JSONObject>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/api/taxes/", method=RequestMethod.GET)
	public String readTaxes(Model model) {
		ArrayList<Taxes> taxes = (ArrayList<Taxes>) taxService.findAll();
		model.addAttribute("taxes", taxes);
		return "taxes";
	}
	
	@RequestMapping(path="/api/taxes/{id}", method=RequestMethod.GET)
	public String readTax(Model model, long id) {
		Optional<Taxes> tax = taxService.findById(id);
		model.addAttribute("tax", tax);
		return "tax";
	}
	
	@RequestMapping(path="/api/taxes/", method=RequestMethod.PUT, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> updateTax(@RequestBody String json) {
		Taxes tax = TransformationUtil.fromJsonToTax(json);
		taxService.update(tax);
	    return new ResponseEntity<JSONObject>(HttpStatus.OK);
	}
	
	@RequestMapping(path="/api/taxes/{id}", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<JSONObject> deleteTax(Model model, long id) {
		taxService.deleteById(id);
	    return new ResponseEntity<JSONObject>(HttpStatus.OK);
	}

}
