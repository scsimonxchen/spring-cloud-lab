package com.spring.cloud.basic.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${book.config}")
	private String msg;

	@RequestMapping("/test")
	public String test() {
		return this.msg;
	}
}
