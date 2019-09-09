package com.lmgroup.salestaxes.controllers;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmgroup.salestaxes.entities.Receipt;
import com.lmgroup.salestaxes.entities.ShoppingBasket;
import com.lmgroup.salestaxes.services.CheckoutService;
import com.lmgroup.salestaxes.utils.TransformationUtil;

@RestController
public class CheckoutController {
	
	protected CheckoutService checkoutService;

	//constructor
	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

	@RequestMapping(path="/api/checkout/", method=RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody ResponseEntity<JSONObject> checkout(@RequestBody String json) {
		ShoppingBasket shoppingBasket = TransformationUtil.fromJsonToShoppingBasket(json);
		Receipt receipt = checkoutService.sellShoppingBasket(shoppingBasket);
	    return new ResponseEntity<JSONObject>(receipt.toJSON(), HttpStatus.OK);
	}

}
