package com.sbank.service;

import java.util.List;

import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;

public interface AccountService {
  
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public Account createAccount(CreateAccountWrapper object) throws HandleException;


  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public Account depositeMoney(WrapperAccountDeposite object) throws HandleException;
 
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public Account withdrawMoney(WrapperAccountDeposite object) throws HandleException;
  

  /**
   * @return
   * @throws HandleException
   */
  public List<Account> getAccountDetails() throws HandleException;
  

  /**
   * @param Id
   * @return
   * @throws HandleException
   */
  public Account getAccountDetail(Long Id) throws HandleException;
  
  /**/
  /**
   * @param account
   * @throws HandleException
   */
  public void updateAccount(Account account) throws HandleException;
 

}
