package com.sbank.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class RefMoney {
  
 /**------RefMoneyId----------*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long RefMoneyId;
  
  /**--------availableDenomination---------*/
  @ElementCollection
  private List<Integer> availableDenomination = new ArrayList();
  
 
  
  public RefMoney()
  {
    
  }
  
  public List<Integer> getAvailableDenomination() {
    return availableDenomination;
  }

  public void setAvailableDenomination(List<Integer> availableDenomination) {
    this.availableDenomination = availableDenomination;
  }


  
  
  
}
