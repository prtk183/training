package com.sbank.service;

import java.util.List;

import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;

public interface AccountService {
  
  public Account createAccount(CreateAccountWrapper object) throws HandleException;

  
  public Account depositeMoney(WrapperAccountDeposite object) throws HandleException;
 

  public Account withdrawMoney(WrapperAccountDeposite object) throws HandleException;
  
  
  public List<Account> getAccountDetails() throws HandleException;
  
  
  public Account getAccountDetail(Long Id) throws HandleException;
 

}
