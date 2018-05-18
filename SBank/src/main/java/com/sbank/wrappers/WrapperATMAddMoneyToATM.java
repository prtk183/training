package com.sbank.wrappers;

import java.math.BigDecimal;

public class WrapperATMAddMoneyToATM {
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

  private BigDecimal amount;
  private BigDecimal bankId;
  private Long atmID;
  
  public Long getAtmID() {
    return atmID;
  }
  public void setAtmID(Long atmID) {
    this.atmID = atmID;
  }
 
  
}
