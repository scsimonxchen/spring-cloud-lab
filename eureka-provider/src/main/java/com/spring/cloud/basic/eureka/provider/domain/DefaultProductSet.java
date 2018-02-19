package com.spring.cloud.basic.eureka.provider.domain;

import java.util.ArrayList;

public class DefaultProductSet extends ArrayList<Product> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DefaultProductSet() {
		this.createProduct(3);
	}

	public DefaultProductSet(int noOfProducts) {
		this.createProduct(noOfProducts);
	}

	private void createProduct(int noOfProducts) {
		for (int i = 0; i < noOfProducts; i++) {
			this.add(new Product(i, "Product " + i));
		}
	}
}
