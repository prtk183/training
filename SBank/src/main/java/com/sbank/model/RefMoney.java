package com.sbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RefMoney {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer denominationref;
  
  private Integer twothousanddenomination=2000;
  private Integer nooftwothousanddenomination=0;
  private Integer fivehundreddenomination=500;
  private Integer nooffivehundreddenomination=0;
 
  private Integer hundreddenomination=100;
  private Integer noofhundreddenomination=0;
  
  @Override
  public String toString() {
    return "RefMoney [denominationref=" + denominationref + ", twothousanddenomination="
        + twothousanddenomination + ", nooftwothousanddenomination=" + nooftwothousanddenomination
        + ", fivehundreddenomination=" + fivehundreddenomination + ", nooffivehundreddenomination="
        + nooffivehundreddenomination + ", hundreddenomination=" + hundreddenomination
        + ", noofhundreddenomination=" + noofhundreddenomination + "]";
  }


  public RefMoney()
  {
    this.twothousanddenomination=2000;
    this.fivehundreddenomination=500;
    this.hundreddenomination=100;
    this.nooftwothousanddenomination=0;
    this.nooffivehundreddenomination=0;
    this.noofhundreddenomination=0;
  }
  
  
  public RefMoney(Integer nooftwothousanddenomination, Integer nooffivehundreddenomination,Integer noofhundreddenomination)
  {
    this.twothousanddenomination=2000;
    this.fivehundreddenomination=500;
    this.hundreddenomination=100;
    this.nooftwothousanddenomination=nooftwothousanddenomination;
    this.nooffivehundreddenomination=nooffivehundreddenomination;
    this.noofhundreddenomination=noofhundreddenomination;
  }
  public Integer getDenominationref() {
    return denominationref;
  }
  public void setDenominationref(Integer denominationref) {
    this.denominationref = denominationref;
  }
  public Integer getTwothousanddenomination() {
    return twothousanddenomination;
  }
  public void setTwothousanddenomination(Integer twothousanddenomination) {
    this.twothousanddenomination = twothousanddenomination;
  }
  public Integer getNooftwothousanddenomination() {
    return nooftwothousanddenomination;
  }
  public void setNooftwothousanddenomination(Integer nooftwothousanddenomination) {
    this.nooftwothousanddenomination = nooftwothousanddenomination;
  }
  public Integer getFivehundreddenomination() {
    return fivehundreddenomination;
  }
  public void setFivehundreddenomination(Integer fivehundreddenomination) {
    this.fivehundreddenomination = fivehundreddenomination;
  }
  public Integer getNooffivehundreddenomination() {
    return nooffivehundreddenomination;
  }
  public void setNooffivehundreddenomination(Integer nooffivehundreddenomination) {
    this.nooffivehundreddenomination = nooffivehundreddenomination;
  }
  
  public Integer getHundreddenomination() {
    return hundreddenomination;
  }
  public void setHundreddenomination(Integer hundreddenomination) {
    this.hundreddenomination = hundreddenomination;
  }
  public Integer getNoofhundreddenomination() {
    return noofhundreddenomination;
  }
  public void setNoofhundreddenomination(Integer noofhundreddenomination) {
    this.noofhundreddenomination = noofhundreddenomination;
  }
  
  
}
