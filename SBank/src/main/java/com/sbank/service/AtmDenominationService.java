package com.sbank.service;

import java.math.BigDecimal;

import com.sbank.exception.HandleException;
import com.sbank.model.Atm_Denomination;

public interface AtmDenominationService {

  Atm_Denomination giveDenomination(Long atmId, BigDecimal amount) throws HandleException;
  
}
