package com.sbank.wrappers;

import java.math.BigDecimal;

import com.sbank.model.Bank;

public class WrapperATMCreate {

  private BigDecimal amount;
  private BigDecimal bankId;
  
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public BigDecimal getBankId() {
    return bankId;
  }
  public void setBankId(BigDecimal bankId) {
    this.bankId = bankId;
  }

  
}
