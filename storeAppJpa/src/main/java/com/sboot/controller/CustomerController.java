package com.sboot.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sboot.model.Customer;
import com.sboot.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl csi;
	
	
	/*
	 *to view customers
	 * */
	@GetMapping("/viewcustomer")
	public ResponseEntity<List<Customer>> viewAllCustomer() {
		//System.out.println("in response cust");
		List<Customer> list = (List<Customer>) csi.viewAllCustomer();
		
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	

	/*
	 * to add customer
	 *  */
	@PostMapping("/addcustomer")
	public ResponseEntity<List<Customer>> addCustomer(@RequestBody Customer customer) {
             String message="";  
          
            message = csi.addCustomer(customer);
             
             return new ResponseEntity<String>(message, HttpStatus.CREATED);
                
	}

	
	/*
	 * to update customer
	 * 
	 * */
	@PutMapping("updatecustomer")
	public ResponseEntity<Customer> updateCustomer (@RequestBody Customer customer) {
		csi.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	/*
	 * to delete customer
	 * 
	 * */
	@DeleteMapping("deletecustomer/{id}")
	public ResponseEntity<Void> deleteCustomer (@PathVariable("id") Integer id) {
		csi.removeCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
}
