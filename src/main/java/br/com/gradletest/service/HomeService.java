package br.com.gradletest.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	public String getNome() {
		return "Adriano "+getSobrenome();
	}
	
	public String getSobrenome() {
		return "Bonfiglio";
	}

}
