package com.example.two.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceOneServiceImpl implements ServiceOneService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public String helloWorld() {
		return restClient.getForObject("http://localhost:8001/helloWorld", String.class);
	}

	@Override
	public String helloWorldError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helloWorldTimeOut() {
		// TODO Auto-generated method stub
		return null;
	}

}
