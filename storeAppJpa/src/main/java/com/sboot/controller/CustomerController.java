package com.sboot.controller;

import java.util.ArrayList;
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
 * 
 * */
	@GetMapping("/viewbyid/{viewlist}")
	public ResponseEntity<List<Customer>> viewById(@PathVariable List<Integer> viewlist)
	{
		List<Customer> list = (List<Customer>) csi.viewcustomerbyid(viewlist);
		
		return  new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		
		
	}
	/*
	 * to add customer
	 *  */
	@PostMapping("/addcustomer")
	public ResponseEntity<String> addCustomer(@RequestBody List<Customer> customer) {
		String addresult="";
          	
		Response response = new Response();
          	
		
             addresult = csi.addCustomers(customer);
             
            return new ResponseEntity<String>(addresult, HttpStatus.CONFLICT);
  
             
                
	}

	
	/*
	 * to update customer
	 * 
	 * */
	@PutMapping("updatecustomer")
	public ResponseEntity<String> updateCustomer (@RequestBody List<Customer> customer) {
		String str;
		str=csi.updateCustomers(customer);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	/*
	 * to delete customer
	 * 
	 * */
	@DeleteMapping("deletecustomer/{id}")
	public ResponseEntity<String> deleteCustomer (@PathVariable("id") List<Integer> id) {
		String str;
		str=csi.removeCustomers(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}	
}
