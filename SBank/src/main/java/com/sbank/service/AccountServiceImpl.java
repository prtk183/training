package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Bank;
import com.sbank.model.Customer;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  BankRepository bankRepository;
  @Autowired
  AccountRepository accountRepository;

  @Override
  public Account createAccount(CreateAccountWrapper object) throws HandleException {
   

    Account account = new Account();
 
    account.setAmount(object.getAmount());
    try {

      Optional op1, op2;
      op1 = customerRepository.findById(object.getCustomerId());
      op2 = bankRepository.findById(object.getBankId());

      account.setAmount(object.getAmount());

      if (op1.isPresent() && op2.isPresent())
      {   //tracing bank and account whether it exist or else throw error
        Customer cust = customerRepository.findById(object.getCustomerId()).get(); 
                                                                                

        account.setCustomer(cust);

        Bank bnk = bankRepository.findById(object.getBankId()).get();

        account.setBank(bnk); 

        BigDecimal initial = bnk.getAmount();
 

        BigDecimal updated = initial.add(object.getAmount());

        bnk.setAmount(updated);

        bankRepository.saveAndFlush(bnk); 

        account = accountRepository.save(account); 
      } else {

        throw new HandleException("Bank or customer id is not valid"); // if bank or customer is not found
      }

    } catch (HandleException e) {
      throw new HandleException("Account is not created");
    }

    return account;
  }

  @Override
  public List<Account> getAccountDetails() throws HandleException {
    // TODO Auto-generated method stub
    List<Account> accountList = null;
    accountList = accountRepository.findAll();
    return accountList;
  }

  @Override
  public Account depositeMoney(WrapperAccountDeposite object) throws HandleException {
    // TODO Auto-generated method stub
    Account act = null;

    Optional op1, op2;
    op1 = customerRepository.findById(object.getCustomerId());
    op2 = bankRepository.findById(object.getBankId());

    try {
 
      if (op1.isPresent() && op2.isPresent()) {   //checking valid customer and bank
        Customer cust = customerRepository.findById(object.getCustomerId()).get();

        Bank bnk = bankRepository.findById(object.getBankId()).get();

        act = accountRepository.findById(object.getAccountId()).get();
        
        BigDecimal val = new BigDecimal(0);

        BigDecimal initialaccount = act.getAmount();
        
        if(object.getAmt().compareTo(val)==1)
        {

        BigDecimal updatedact = initialaccount.add(object.getAmt()); // adding depositing in account
        act.setAmount(updatedact);
        }
        else
        {
          throw new HandleException("amount can not be null");
        }
        

        
        accountRepository.saveAndFlush(act);

        BigDecimal initialbank = bnk.getAmount();

        BigDecimal updatedbnk = initialbank.add(object.getAmt()); // adding depositing into bank

        bnk.setAmount(updatedbnk);

        bankRepository.saveAndFlush(bnk);

      } else {
        throw new HandleException("Data is incorret");
      }
    } catch (HandleException e) {
      throw new HandleException("Amount is not deposited");
    }
    return act;

  }

  @Override
  public Account withdrawMoney(WrapperAccountDeposite object) throws HandleException {
    Account act = null;

    try {
      /*
       * validating bank and account and getting corresponding error
       * 
       */
      Optional op1 = bankRepository.findById(object.getBankId());
      Optional op2 = accountRepository.findById(object.getAccountId());
      if (op2.isPresent() && op1.isPresent()) {

        Customer cust = customerRepository.findById(object.getCustomerId()).get();

        Bank bnk = bankRepository.findById(object.getBankId()).get();

        act = accountRepository.findById(object.getAccountId()).get();

        BigDecimal initialaccount = act.getAmount();
        
        if(object.getAmt().compareTo(initialaccount)==-1 && object.getAmt().compareTo(initialaccount)==0)
        {

        BigDecimal updatedact = initialaccount.subtract(object.getAmt()); // withdrawing
                                                                          // substracting in account

        act.setAmount(updatedact);
        }
        else
        {
          throw new HandleException("withdrwa amount is more than exixting amount");
        }
        
        
        BigDecimal initialbank = bnk.getAmount();
        BigDecimal val = new BigDecimal(100);
        if (initialbank.compareTo(val) == 1) {

          BigDecimal updatedbnk = initialbank.subtract(object.getAmt()); // withdrawing into bank

          bnk.setAmount(updatedbnk);

        } else {
          throw new HandleException("insufficeiant ammount");
        }

        bankRepository.saveAndFlush(bnk);
        accountRepository.saveAndFlush(act);

        }
        else
        {
          throw new HandleException("bankid or acounid is not valid");
        }

    } catch (HandleException e) {
      throw new HandleException("withdraw can be possible");
    }

    return act;

  }

  @Override
  public Account getAccountDetail(Long Id) throws HandleException  {

    Optional op;
    Account account=null;
    op = accountRepository.findById(Id);
    if(op.isPresent())
    {
       account = accountRepository.findById(Id).get();
   
    }
    return account;
    
  }

}
