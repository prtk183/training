package com.sbank.wrappers;

import com.sbank.model.RefMoney;

public class BankPermission {
  
  public BankPermission()
  {
    
  }
  public Long getBankId() {
    return BankId;
  }
  public void setBankId(Long bankId) {
    BankId = bankId;
  }
  public RefMoney getRef() {
    return ref;
  }
  public void setRef(RefMoney ref) {
    this.ref = ref;
  }
  private Long BankId;
  private RefMoney ref;
}
