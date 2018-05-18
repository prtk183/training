package com.sbank;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.sbank.controller.BankController;
import com.sbank.model.Bank;


@SpringBootApplication
public class SBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBankApplication.class, args);
	}
	
	public SBankApplication(){};
	
	public Bank addBank(BigDecimal amount) {
	  
    final String uri = "http://localhost:8080/createbank";

    RestTemplate restTemplate = new RestTemplate();

    Bank result = restTemplate.postForObject(uri, amount, Bank.class);

    System.out.println(result);
    
    return result;
  }
}
