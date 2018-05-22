package com.sbank.service;

import java.util.List;

import com.sbank.exception.HandleException;
import com.sbank.model.RefMoney;

public interface RefMoneyService {

  public  List<Integer> update(Integer currency) throws HandleException;
  
  public List<Integer> getRefTable() throws HandleException;
}
