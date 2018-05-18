package com.sbank.wrappers;

import java.math.BigDecimal;

import com.sbank.model.Account;
import com.sbank.model.Customer;

public class WrapperTransaction {

  public Long getCustomerId() {
    return customerId;
  }
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
  public Long getAccount() {
    return account;
  }
  public void setAccount(Long account) {
    this.account = account;
  }
  public String getTtype() {
    return ttype;
  }
  public void setTtype(String ttype) {
    this.ttype = ttype;
  }
  
  private Long customerId;
  private Long account;
  private String ttype;
  private BigDecimal amount;
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  
  
}
