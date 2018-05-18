package com.sbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbank.model.Account;
import com.sbank.model.Transaction;
import com.sbank.service.TransactionServiceImpl;
import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperTransaction;

@Controller
public class TransactionController {
  
  @Autowired
  TransactionServiceImpl transactonServiceImpl;
  
  @PostMapping("/createtransaction")
   public  ResponseEntity<Transaction> createTransaction( @RequestBody WrapperTransaction object)
  {
  
     
     Transaction tax = transactonServiceImpl.createTransaction(object);
     
       return new ResponseEntity<Transaction>(tax, HttpStatus.OK);
        
  
  }
  
}
