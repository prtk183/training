package com.sbank.service;

import java.util.List;

import com.sbank.exception.HandleException;
import com.sbank.model.Transaction;
import com.sbank.wrappers.WrapperTransaction;

public interface TransactionService {

  /**/
  /**
   * @param obj
   * @return
   * @throws HandleException
   */
  public Transaction createTransaction(WrapperTransaction obj) throws HandleException;
  
  /**/
  /**
   * @param obj
   * @return
   * @throws HandleException
   */
  public List<Transaction> generteTransactionReport(WrapperTransaction obj) throws HandleException;

}
