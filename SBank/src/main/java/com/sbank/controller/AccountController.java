package com.sbank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Bank;
import com.sbank.service.AccountServiceImpl;
import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;

@Controller
public class AccountController {
  
 
  
  
  @Autowired
  AccountServiceImpl accountServiceImpl;
  /*
   * calling createAccount taking wrapper object containig customerid, account id and amount
   * 
   * */
  @PostMapping("/createaccount")
  public ResponseEntity<Account> callcreateAccount( @RequestBody CreateAccountWrapper object) throws HandleException  
  {
      
    Account act = accountServiceImpl.createAccount(object);
  
    return new ResponseEntity<Account>(act, HttpStatus.OK);
     
  }
  
  @GetMapping("/getaccounts")
  public ResponseEntity<List<Account>> callgetAccountDetails() throws HandleException
  {
    
    List<Account> accountList = accountServiceImpl.getAccountDetails();

    return  new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    
  }
  
  @PostMapping("/depositemoney")
  public  ResponseEntity<Account> depositeMoney(@RequestBody WrapperAccountDeposite object) throws HandleException
  {
    
    Account act = accountServiceImpl.depositeMoney(object);
    return new ResponseEntity<Account>(act, HttpStatus.OK);
  }

  
  @PostMapping("/withdrawmoneyfromaccount")
  public ResponseEntity<Account> withdrawMoney(@RequestBody WrapperAccountDeposite object) throws HandleException
  {
    Account act = accountServiceImpl.withdrawMoney(object);
    return new ResponseEntity<Account>(act, HttpStatus.OK);
  }
  
 
}
