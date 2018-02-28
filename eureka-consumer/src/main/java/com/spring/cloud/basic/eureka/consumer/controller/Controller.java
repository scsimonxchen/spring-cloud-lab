package com.spring.cloud.basic.eureka.consumer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.basic.eureka.consumer.domain.Product;
import com.spring.cloud.basic.eureka.consumer.services.ProductService;

@RestController
public class Controller {
	@Autowired
	private ProductService service;

	//private static final Logger LOG = Logger.getLogger(Controller.class.getName());

	@RequestMapping(value = "loadRibbonServiceDefaultProductSet", method = RequestMethod.GET)
	public List<Product> loadRibbonServiceDefaultProductSet() {
		List<Product> pList = service.loadRibbonServiceDefaultProductSet();
		return pList;
	}
}
