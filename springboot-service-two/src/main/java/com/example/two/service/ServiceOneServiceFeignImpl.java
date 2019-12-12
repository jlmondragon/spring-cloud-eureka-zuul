package com.example.two.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.two.client.ServiceOneClientRest;

@Service
@Primary
public class ServiceOneServiceFeignImpl implements ServiceOneService {

	@Autowired
	private ServiceOneClientRest serviceOneClientRest;
	
	@Override
	public String helloWorld() {
		return serviceOneClientRest.helloWorld();
	}
	
	@Override
	public String helloWorldError() {
		return serviceOneClientRest.helloWorldError();
	}

	@Override
	public String helloWorldTimeOut() {
		return serviceOneClientRest.helloWorldTimeOut();
	}

}
