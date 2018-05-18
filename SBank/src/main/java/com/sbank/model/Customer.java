package com.sbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "CUSTOMER")
public class Customer {

  @Override
  public String toString() {
    return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", pin=" + pin
        + "]";
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long customerId;

  private String customerName;

  private Integer pin;

  @ManyToOne(targetEntity = Bank.class, fetch=FetchType.LAZY)
  private Bank bank;

  public Customer(String customerName, Integer pin, Bank bank) {

    this.bank = bank;
    this.customerName = customerName;
    this.pin = pin;

  }

  public Customer() {
    // TODO Auto-generated constructor stub
  }

  /*
   * @OneToOne
   * 
   * @JoinColumn(name = "accountId", nullable = false) private Account account;
   * 
   * public Account getAccount() { return account; }
   * 
   * public void setAccount(Account account) { this.account = account; }
   */

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBankId(Bank bank) {
    this.bank = bank;
  }

  /**
   * @return the customerId
   */
  public Long getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId
   *          the customerId to set
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  /**
   * @return the customerName
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * @param customerName
   *          the customerName to set
   */
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  /**
   * @return the pin
   */
  public Integer getPin() {
    return pin;
  }

  /**
   * @param pin
   *          the pin to set
   */
  public void setPin(Integer pin) {
    this.pin = pin;
  }

}
