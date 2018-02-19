package com.spring.cloud.basic.eureka.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.basic.eureka.provider.domain.DefaultProductSet;
import com.spring.cloud.basic.eureka.provider.domain.Product;

import java.util.List;

@RestController
public class Controller {

	@RequestMapping(value="defaultProductSet",method=RequestMethod.GET)
	public List<Product> listDefaultProductSet(){
		return new DefaultProductSet();
	}
}
