package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank;
import com.sbank.model.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	 @Autowired
	  BankRepository bankrepository;
	

	
	/*
	* creating customer
	*
	*/
	@Override
	public Customer createCustomer(Customer customer) throws HandleException {
	  Customer addNewCustomer =null;
	
	   Bank bid=customer.getBank();
	   BigDecimal id = bid.getBankId();

	  
	   Optional op = bankrepository.findById(id);
	    
	   try
     {
	    if(op.isPresent() )  //cheking valid bank in argument 
	    {
	      if( customer.getCustomerName().isEmpty() && customer.getCustomerName().isEmpty())  //checking valid customer data
	      {
	        throw new HandleException("data can not be null");

	      }
	      else
	      {
	        addNewCustomer =  customerRepository.save(customer);
	      }
	    }
	    else
	    {
	      throw new HandleException("bank id is not valid "); 
	    }
     }
	  catch(HandleException e)
	  {

	    throw new HandleException("customer is not created "); 
	  }
	   
	 return addNewCustomer;
	
	}



/*
* showing customers
*/
	@Override
	public List<Customer> getCustomerdetails() throws HandleException {
		
		List<Customer> custlist;
		
		custlist=customerRepository.findAll();
		
		  return custlist;
	}



  @Override
  public Customer getCustomer(Long customerId) throws HandleException {
    
    Optional op;
    Customer customer=null;
    
    op= customerRepository.findById(customerId);
    if(op.isPresent())
    {
        customer = customerRepository.findById(customerId).get();
    }
    
    
    return customer;
  }
		

}
