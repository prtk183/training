package com.sbank.wrappers;

import java.math.BigDecimal;

public class WrapperATMWithdraw {
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

  public Long getAtmId() {
    return atmId;
  }
  public void setAtmId(Long atmId) {
    this.atmId = atmId;
  }
  public Long getAccountId() {
    return accountId;
  }
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }
  private BigDecimal amount;
  private BigDecimal bankId;
  private Long atmId;
  private Long accountId;
}
