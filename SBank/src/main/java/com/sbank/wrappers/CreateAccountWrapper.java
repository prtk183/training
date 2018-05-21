package com.sbank.wrappers;

import java.math.BigDecimal;

import com.sbank.model.Bank;
import com.sbank.model.Customer;

public class CreateAccountWrapper {
  
  public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
  @Override
  public String toString() {
    return "CreateAccountWrapper [bankId=" + bankId + ", customerId=" + customerId + ", amount="
        + amount + "]";
  }
  public Long getCustomerId() {
    return customerId;
  }
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  private Long bankId;
  private Long customerId;
  private BigDecimal amount;

}