package com.sbank.wrappers;

import java.math.BigDecimal;

public class WrapperATMAddMoneyToATM {
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public Long getBankId() {
    return bankId;
  }
 
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

  private BigDecimal amount;
  private Long bankId;
  private Long atmID;
  
  public Long getAtmID() {
    return atmID;
  }
  public void setAtmID(Long atmID) {
    this.atmID = atmID;
  }
 
  
}
