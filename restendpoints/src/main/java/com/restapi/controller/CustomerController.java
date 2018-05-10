package com.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restapi.model.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	List<Customer> customerList = new ArrayList<Customer>();
	
	@GetMapping("/viewcustomer")
	public @ResponseBody List<Customer> viewCustomer()
	{
		Customer c1 = new Customer(101,"dfnsb","dn","yomail");
		Customer c2 = new Customer(102,"dfnsb","dn","yomail");

		
		customerList.add(c1);
		customerList.add(c2);	
		
		return customerList;
	}
	
	
	/*
	 * to add customer i will send 
	 * */

	
	
	
	
}
