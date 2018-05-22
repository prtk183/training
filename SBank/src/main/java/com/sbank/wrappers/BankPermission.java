package com.sbank.wrappers;

import java.math.BigDecimal;



import com.sbank.model.RefMoney;

public class BankPermission {
  /**------------*/
  private Long Id;
  /**------------*/
  private BigDecimal requestamount;
  
  /**-------------*/
  /**
   * 
   */
  public BankPermission()
  {
    
  }

 
  /**
   * @return
   */
  public BigDecimal getRequestamount() {
    return requestamount;
  }

  
  /**
   * @param requestamount
   */
  public void setRequestamount(BigDecimal requestamount) {
    this.requestamount = requestamount;
  }
 

  /**
   * @return
   */
  public Long getId() {
    return Id;
  }


  /**
   * @param id
   */
  public void setId(Long id) {
    Id = id;
  }

}
