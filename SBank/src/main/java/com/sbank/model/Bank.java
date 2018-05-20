
package com.sbank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author trainee
 *
 */

@Entity
@Table(name = "BANK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bank {

  /**
   * 
   * consutructor
   */

  public Bank(BigDecimal amount) {
    this.amount = amount;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "bank_Id")
  private Long bankId;

  public Long getBankId() {
    return bankId;
  }

  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

  @Column(name = "amount")
  private BigDecimal amount;

  /*
   * @return the amount
   */
  public BigDecimal getAmount() {
    return amount;
  }

  /**
   * @param amount
   *          the amount to set
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Bank() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Bank [bankId=" + bankId + ", amount=" + amount + "]";
  }

}
