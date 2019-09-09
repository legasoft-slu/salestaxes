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

import com.lmgroup.salestaxes.entities.Products;
import com.lmgroup.salestaxes.services.ProductService;
import com.lmgroup.salestaxes.utils.TransformationUtil;


@Controller
public class ProductController {
	
	protected ProductService productService;

	//constructor
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(path="/api/products/", method=RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> createProduct(@RequestBody String json) {
		Products product = TransformationUtil.fromJsonToProduct(json);
		productService.create(product);
	    return new ResponseEntity<JSONObject>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/api/products/", method=RequestMethod.GET)
	public String readProducts(Model model) {
		ArrayList<Products> products = (ArrayList<Products>) productService.findAll();
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping(path="/api/products/{id}", method=RequestMethod.GET)
	public String readProduct(Model model, long id) {
		Optional<Products> product = productService.findById(id);
		model.addAttribute("product", product);
		return "product";
	}
	
	@RequestMapping(path="/api/products/", method=RequestMethod.PUT, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> updateProduct(@RequestBody String json) {
		Products product = TransformationUtil.fromJsonToProduct(json);
		productService.update(product);
	    return new ResponseEntity<JSONObject>(HttpStatus.OK);
	}
	
	@RequestMapping(path="/api/products/{id}", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<JSONObject> deleteProduct(Model model, long id) {
		productService.deleteById(id);
	    return new ResponseEntity<JSONObject>(HttpStatus.OK);
	}

}
