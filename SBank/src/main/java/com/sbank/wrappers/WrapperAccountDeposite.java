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
  public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  private Long accountId;
  private Long customerId;
  private Long bankId;
  private BigDecimal amount;
  private Long RefId;
  public Long getRefId() {
    return RefId;
  }
  public void setRefId(Long refId) {
    RefId = refId;
  }
}
