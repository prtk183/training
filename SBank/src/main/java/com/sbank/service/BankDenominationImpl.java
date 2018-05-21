package com.sbank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.BankDenominationRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank_Denomination;
import com.sbank.model.RefMoney;
import com.sbank.wrappers.BankPermission;

@Service
public class BankDenominationImpl implements BankDenominationService{

  @Autowired
  BankServiceImpl bankServiceImpl;
  
  @Autowired
  RefMoneyServiceImpl refMoneySErviceImpl;
  @Autowired
  BankDenominationRepository bankDenominationRepository;
  
  @Override
  public boolean getDenominationPermission(BankPermission object) throws HandleException {

    Integer bankamount = bankServiceImpl.getBank(object.getBankId()).getAmount().intValue();
    
    if(bankamount%2==0)
    {
      
        while(bankamount!=0)
        {
            if(bankamount>=2000)
            {
              object.getRef().setNooftwothousanddenomination(bankamount/2000);
              bankamount = bankamount%object.getRef().getTwothousanddenomination();
            } else if(bankamount<=500)
                {
              object.getRef().setFivehundreddenomination(bankamount/500);
                  bankamount = bankamount%object.getRef().getFivehundreddenomination();
                } else if(bankamount>=100)
                      {
                  object.getRef().setHundreddenomination(bankamount/100);
                        bankamount =  bankamount%object.getRef().getHundreddenomination();
                        } else {
                              throw new HandleException("not valid amount");      
                            }
          }
       
       System.out.println("final denomiantion"+object.getRef());
       refMoneySErviceImpl.update(object.getRef());
      
       Bank_Denomination bankDenomination = new Bank_Denomination( bankServiceImpl.getBank(object.getBankId()), object.getRef(),bankServiceImpl.getBank(object.getBankId()).getAmount());
       
       bankDenominationRepository.save(bankDenomination);
       
       return true;
    } 
    else
    {
        throw new HandleException("amount is not in existing denominations");
    }
    }

}
