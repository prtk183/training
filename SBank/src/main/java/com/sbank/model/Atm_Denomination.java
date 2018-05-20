package com.sbank.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Atm_Denomination")
public class Atm_Denomination {

  @Id
  private Long atmId;
  
  @ElementCollection
  private List<Integer> denomination;
  
  @ElementCollection
  private Map<Integer,Integer> noofdenomination;
  
  private BigDecimal amount;
  private Boolean permission=false;
 
  public Boolean getPermission() {
    return permission;
  }

  public void setPermission(Boolean permission) {
    this.permission = permission;
  }

  public Atm_Denomination()
  {
    
  }
  
  public Atm_Denomination(Long atmId, BigDecimal amount, List<Integer> denomination, Map<Integer, Integer> noofdenomination)
  {
    this.atmId=atmId;
    this.amount=amount;
    this.denomination=denomination;
    this.noofdenomination=noofdenomination;
    this.permission=true;
    
 
  }
  public List<Integer> getDenomination() {
    return denomination;
  }

  public void setDenomination(List<Integer> denomination) {
    this.denomination = denomination;
  }

  public Map<Integer, Integer> getNoofdenomination() {
    return noofdenomination;
  }

  public void setNoofdenomination(Map<Integer, Integer> noofdenomination) {
    this.noofdenomination = noofdenomination;
  }
  
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
 
  public Long getAtmId() {
    return atmId;
  }
  public void setAtmId(Long atmId) {
    this.atmId = atmId;
  }

 
  
}
