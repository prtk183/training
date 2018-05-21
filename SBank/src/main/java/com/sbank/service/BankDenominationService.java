package com.sbank.service;

import com.sbank.exception.HandleException;
import com.sbank.model.RefMoney;
import com.sbank.wrappers.BankPermission;

public interface BankDenominationService {


  boolean getDenominationPermission(BankPermission object) throws HandleException;
}
