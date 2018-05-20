/**
 * 
 */
package com.sbank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank;
import com.sbank.model.Customer;
import com.sbank.service.BankServiceImpl;
import com.sbank.service.CustomerServiceImpl;
import com.sbank.wrappers.WrapperClass;

/**
 * @author trainee
 *
 */
@Controller
public class CustomerController {

  @Autowired
  CustomerServiceImpl customerServiceImpl;

  @Autowired
  BankServiceImpl bankServiceImpl;

  /**
   * 
   * to add a customer wrapper class including customer object and bank id is sent
   * corresponding bank is traced as per its id and banks foreign key is traced back 
   * @param wrapperClass
   * @return
   * @throws HandleException
   */
  @PostMapping(path = "/createcustomer", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Customer> addOneCustomer(@RequestBody WrapperClass wrapperClass) throws HandleException {

 
    Bank b = bankServiceImpl.getBank(wrapperClass.bankId);
    Customer cust = wrapperClass.customer;
    cust.setBankId(b);
    Customer result = customerServiceImpl.createCustomer(cust);

    return new ResponseEntity<Customer>(result, HttpStatus.OK);
    
  }


  /**
   * finding customers
   * @return
   * @throws HandleException
   */
  @GetMapping("/viewcustomer")
  public ResponseEntity<List<Customer>> viewCustomer() throws HandleException {
    List<Customer> result = customerServiceImpl.getCustomerdetails();

    return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);

  }

}
