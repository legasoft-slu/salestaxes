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

import com.lmgroup.salestaxes.entities.ProductTypes;
import com.lmgroup.salestaxes.services.ProductTypeService;
import com.lmgroup.salestaxes.utils.TransformationUtil;


@Controller
public class ProductTypeController {
	
	protected ProductTypeService productTypeService;

	//constructor
	public ProductTypeController(final ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}
	
	@RequestMapping(path="/api/producttypes/", method=RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> createProductType(@RequestBody String json) {
		ProductTypes productType = TransformationUtil.fromJsonToProductType(json);
		productTypeService.create(productType);
	    return new ResponseEntity<JSONObject>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/api/producttypes/", method=RequestMethod.GET)
	public String readProductTypes(Model model) {
		ArrayList<ProductTypes> productTypes = (ArrayList<ProductTypes>) productTypeService.findAll();
		model.addAttribute("productTypes", productTypes);
		return "productTypes";
	}
	
	@RequestMapping(path="/api/producttypes/{id}", method=RequestMethod.GET)
	public String readProductType(Model model, long id) {
		Optional<ProductTypes> productTypes = productTypeService.findById(id);
		model.addAttribute("productTypes", productTypes);
		return "productTypes";
	}
	
	@RequestMapping(path="/api/producttypes/", method=RequestMethod.PUT, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> updateProductType(@RequestBody String json) {
		ProductTypes productType = TransformationUtil.fromJsonToProductType(json);
		productTypeService.update(productType);
	    return new ResponseEntity<JSONObject>(HttpStatus.OK);
	}
	
	@RequestMapping(path="/api/producttypes/{id}", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<JSONObject> deleteProductType(Model model, long id) {
		productTypeService.deleteById(id);
	    return new ResponseEntity<JSONObject>(HttpStatus.OK);
	}

}
