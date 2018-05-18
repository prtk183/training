package com.sbank.wrappers;

import java.math.BigDecimal;

public class WrapperAccountDeposite {
  
  public Long getAccountId() {
    return accountId;
  }
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }
  public Long getCustomerId() {
    return customerId;
  }
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
  public BigDecimal getBankId() {
    return bankId;
  }
  public void setBankId(BigDecimal bankId) {
    this.bankId = bankId;
  }
  public BigDecimal getAmt() {
    return amt;
  }
  public void setAmt(BigDecimal amt) {
    this.amt = amt;
  }
  private Long accountId;
  private Long customerId;
  private BigDecimal bankId;
  private BigDecimal amt;
}
