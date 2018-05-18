package com.sbank.service;

import org.springframework.stereotype.Service;

import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;
@Service
public interface ATMService {

  public ATM createATM(WrapperATMCreate object) throws HandleException;
  
  public ATM addMoneyFromBank(WrapperATMAddMoneyToATM object) throws HandleException;
  
  public ATM withdrawMoney(WrapperATMWithdraw object) throws HandleException;
}
