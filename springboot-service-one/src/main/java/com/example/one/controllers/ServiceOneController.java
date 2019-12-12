package com.example.one.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/helloWorld")
	public String helloWorld() throws Exception {
		return "Hello world, service one, port: " + port;
	}

	@GetMapping("/helloWorldError")
	public String helloWorldError() throws Exception {
		// Prueba de error con hystrix
		boolean ok = false;
		if (!ok) {
			throw new Exception("Error al saludar");
		}

		return "Hello world, service one, port: " + port;
	}

	@GetMapping("/helloWorldTimeOut")
	public String helloWorldTimeOut() {
		// Se va a lanzar un error ya que por defecto en ribbon y hystrix está
		// configurado para que no tarde más de 1s el método en dar respuesta, al menos
		// que en la configuración se configure

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Hello world, service one timeout";
	}

}
