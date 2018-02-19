package com.spring.cloud.basic.eureka.consumer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.spring.cloud.basic.eureka.consumer.domain.Product;

@Service
public class ProductService {

	public ProductService() {
		super();
	}

	@Autowired
	private LoadBalancerClient loadBalancerClient; // ribbon client for load balancing

	public List<Product> loadRibbonServiceDefaultProductSet() {
		ServiceInstance serviceInstace = loadBalancerClient.choose("eureka-basic-provider");
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("http://");
		strBuf.append(serviceInstace.getHost());
		strBuf.append(":");
		strBuf.append(serviceInstace.getPort());
		strBuf.append("/defaultProductSet");

		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> resp = rt.exchange(strBuf.toString(), HttpMethod.GET, null, typeRef);
		List<Product> plist = resp.getBody();
		return plist;
	}
}
