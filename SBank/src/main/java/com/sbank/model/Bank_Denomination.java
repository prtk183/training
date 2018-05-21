package com.sbank.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Bank_Denomination {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long bankdenominationref;
  @ManyToOne(targetEntity=Bank.class)
  private Bank bank;
  
  @OneToOne(targetEntity=RefMoney.class)
  private RefMoney denomination;
 
  private BigDecimal amount;
  
  public Bank_Denomination()
  {
    
  }
  public Bank_Denomination(Bank bank, RefMoney ref, BigDecimal amount)
  {
    this.bank=bank;
    this.denomination=ref;
    this.amount=amount;
  }

  public Long getBankdenominationref() {
    return bankdenominationref;
  }

  public void setBankdenominationref(Long bankdenominationref) {
    this.bankdenominationref = bankdenominationref;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public RefMoney getDenomination() {
    return denomination;
  }

  public void setDenomination(RefMoney denomination) {
    this.denomination = denomination;
  }
  
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  
}
