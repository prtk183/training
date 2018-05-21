package com.sbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Transaction;
import com.sbank.service.TransactionServiceImpl;
import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperTransaction;

@Controller
public class TransactionController {
  
  @Autowired
  TransactionServiceImpl transactonServiceImpl;
  
  
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/createtransaction")
   public  ResponseEntity<Transaction> createTransaction( @RequestBody WrapperTransaction object) throws HandleException
   {
     Transaction tax = transactonServiceImpl.createTransaction(object);
     
       return new ResponseEntity<Transaction>(tax, HttpStatus.OK);
    }
  
  
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  @GetMapping("/generatetransactionreport/{accountId}")
  public  ResponseEntity<List<Transaction>> generatetransactionreport( @PathVariable Long accountId) throws HandleException
  {  
    List<Transaction> tax = transactonServiceImpl.generteTransactionReport(accountId);
     
       return new ResponseEntity<List<Transaction>>(tax, HttpStatus.OK);
    }
  
}
