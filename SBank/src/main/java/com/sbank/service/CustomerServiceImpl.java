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
	  BankServiceImpl bankServiceImpl;
	/**/
	/* crating customer with id, pi, name and bankid
	 * @see com.sbank.service.CustomerService#createCustomer(com.sbank.model.Customer)
	 */
	@SuppressWarnings("unlikely-arg-type")
  @Override
	public Customer createCustomer(Customer customer) throws HandleException {
	  Customer addNewCustomer =null;
	
	   Bank bid=customer.getBank();
	   Long id = bid.getBankId();
	   System.out.println("search in db "+bankServiceImpl.getBank(customer.getBank().getBankId()));
	   System.out.println("id in object"+customer.getBank().getBankId());
	    
	  if(( bankServiceImpl.getBank(customer.getBank().getBankId()).getBankId().equals(customer.getBank().getBankId()) )) //cheking valid bank in argument 
	    {
	        if( customer.getCustomerName().isEmpty() && customer.getCustomerName().isEmpty())  //checking valid customer data
	          {
	              throw new HandleException("data can not be null");
	          } else {
	                      addNewCustomer =  customerRepository.save(customer);
	                      return addNewCustomer;
	         }
	    } else {
	      throw new HandleException("bank id is not valid "); 
	    }
	}



	/*
   * showing customers
   * 
	 * @see com.sbank.service.CustomerService#getCustomerdetails()
	 */
	@Override
	public List<Customer> getCustomerdetails() throws HandleException {
		
		List<Customer> custlist;
		
		custlist=customerRepository.findAll();
		
		if(custlist.size()==0)
		{
		  throw new HandleException("NO data found");
		}
		else
		{
		  return custlist;
		}
	}


	/**/
  /* get customer by id
   * @see com.sbank.service.CustomerService#getCustomer(java.lang.Long)
   */
  @Override
  public Customer getCustomer(Long customerId) throws HandleException {
    
    Optional op;
    Customer customer=null;
    
    op= customerRepository.findById(customerId);
    if(op.isPresent())
    {
        customer = customerRepository.findById(customerId).get();
        return customer;
    }
    else
    {
      throw new HandleException("customer data not found by id");
    }
    
   
  }
		

}
