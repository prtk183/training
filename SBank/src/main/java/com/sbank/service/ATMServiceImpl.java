package com.sbank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.ATMRepository;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.model.Account;
import com.sbank.model.Bank;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;

@Service
public class ATMServiceImpl implements ATMService{

  @Autowired
  BankRepository bankrepository;
  @Autowired
  ATMRepository atmrepository;
  @Autowired
  AccountRepository accountrepository;
  
  @Override
  public ATM createATM(WrapperATMCreate object) throws HandleException {
  
    ATM atm = new ATM();
    
    atm.setAmount(object.getAmount());
    atm.setBank(bankrepository.findById(object.getBankId()).get());
    
    atm=atmrepository.save(atm);
    
    return atm;
  }

  @Override
  public ATM addMoneyFromBank(WrapperATMAddMoneyToATM object) throws HandleException {
    // TODO Auto-generated method stub
    ATM atm =null;
    try
    {
      Optional op1, op2;
      
      op1=atmrepository.findById(object.getAtmID());
      op2=bankrepository.findById(object.getBankId());
      if(op1.isPresent() && op2.isPresent())            //checking for valid data
      {
      
         atm = atmrepository.findById(object.getAtmID()).get();
  
         atm.setAmount(atm.getAmount().add(object.getAmount()));
  
         atm.setBank(bankrepository.findById(object.getBankId()).get());
 
         Bank bank = bankrepository.findById(object.getBankId()).get();

         BigDecimal bankamount = bank.getAmount();
         
         if(object.getAmount().compareTo(bankamount)==-1)        //checking for valid amount transefer
         {
         bank.setAmount(bank.getAmount().subtract(object.getAmount()));
         bankrepository.saveAndFlush(bank);
         
         atm=atmrepository.save(atm);
         }
         else
         {
           throw new HandleException("invalid amount transfer request");
         }

        
      }
      else
      {
        throw new HandleException("invalid data");
      }
  
    }
    catch(HandleException e)
    {
      throw new HandleException("Money can not be added into atm");
    }
    
    return atm;
    
  }

  @Override
  public ATM withdrawMoney(WrapperATMWithdraw object) throws HandleException {
    // TODO Auto-generated method stub
    ATM atm =null;
    Optional op1, op2, op3;
    try
    {
      op1= atmrepository.findById(object.getAtmId());
      op2= bankrepository.findById(object.getBankId());
      op3= accountrepository.findById(object.getAccountId());
      
      if(op1.isPresent() && op2.isPresent() && op3.isPresent())   //validating the data
      {
        atm = atmrepository.findById(object.getAtmId()).get();
        atm.setAmount(atm.getAmount().subtract(object.getAmount()));
      
        Bank bank = bankrepository.findById(object.getBankId()).get();
        BigDecimal initial = new BigDecimal(100);
        if((object.getAmount().compareTo(atm.getAmount())==-1) && (object.getAmount().compareTo(initial))==1) //validating the requested amount
                                                                                                             //against money in atm
        {
          bank.setAmount(atm.getAmount().subtract(object.getAmount()));
        }
        else
        {
          throw new HandleException("enter the valid amount");
        }
        bankrepository.saveAndFlush(bank);

        Account account = accountrepository.findById(object.getAccountId()).get();
        account.setAmount(account.getAmount().subtract(object.getAmount()));
        accountrepository.saveAndFlush(account);
       }
      else
      {
        throw new HandleException("invalid data");
      }
    }
    catch(HandleException g)
    {
      throw new HandleException("withdraw can not be done");
    }

    return atm;
  }

}
