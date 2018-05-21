package com.sbank.service;

import com.sbank.exception.HandleException;
import com.sbank.model.RefMoney;

public interface RefMoneyService {

  public RefMoney update(RefMoney refMoney) throws HandleException;
  
  public RefMoney getRef(Long refId) throws HandleException;
}
