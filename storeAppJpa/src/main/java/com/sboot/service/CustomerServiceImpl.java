package com.sboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sboot.model.Customer;
import com.sboot.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo crepo;

	Iterable<Customer> customerList = new ArrayList<Customer>();

	@Override
	public List<Customer> viewAllCustomer() {
		// TODO find all customers

		return (List<Customer>) crepo.findAll();
	}

	@Override
	public String addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String string="";

		boolean flag = false;
		Optional<Customer> id = crepo.findById(customer.getCustomerId());
		// System.out.println("checking");
		if (id.isPresent()) {

			return "Customer already exists!";
		} else {
			crepo.save(customer);
			return "Customer added succesfully!";
		}
	
		
	}

	@Override
	public void removeCustomer(int cid) {
		// TODO Auto-generated method stub

		crepo.deleteById(cid);
		;

	}

	@Override
	public void updateCustomer(Customer customer) {

		// TODO Auto-generated method stub

		Optional<Customer> id = crepo.findById(customer.getCustomerId());
		// System.out.println("checking");
		if (id.isPresent()) {
			System.out.println("data doesnot exixst");
		} else {
			crepo.save(customer);

		}

	}

}
