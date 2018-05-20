package com.sbank.model;

import java.math.BigDecimal;

public class Bank_Denomination {

  private Long bankId;
  private BigDecimal denomination;
  private Integer noofdenomination;
  
  Bank_Denomination()
  {
    
  }
  
  public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
  public BigDecimal getDenomination() {
    return denomination;
  }
  public void setDenomination(BigDecimal denomination) {
    this.denomination = denomination;
  }
  public Integer getNoofdenomination() {
    return noofdenomination;
  }
  public void setNoofdenomination(Integer noofdenomination) {
    this.noofdenomination = noofdenomination;
  }
 
  
}
