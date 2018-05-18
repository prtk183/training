package com.sbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.AccountRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.dao.TransactionRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Customer;
import com.sbank.model.Transaction;
import com.sbank.wrappers.WrapperTransaction;

@Service
public class TransactionServiceImpl implements TransactionService{

  @Autowired
  private AccountServiceImpl accountServiceImpl;
  @Autowired
  private CustomerServiceImpl customerServiceImpl;
  @Autowired
  private TransactionRepository transactionRepository;
  
  @Override
  public Transaction createTransaction(WrapperTransaction obj) throws HandleException {
    
  try
  {
    Transaction tax=null;
    Customer customer = null;
    Account account = null;
    
    try {
      account = accountServiceImpl.getAccountDetail(obj.getAccount());
    } catch (HandleException e) {

   throw new HandleException("account not found");
    }
    
    try {
      customer = customerServiceImpl.getCustomer(obj.getCustomerId());
    } catch (HandleException e) {
    
      throw new HandleException("customer not found");
    }
    
    String ttype= obj.getTtype();
    
    tax.setAccount(account);
    tax.setCustomer(customer);
    tax.setTransactionType(ttype);
    tax.setAmount(obj.getAmount());
    
    tax=transactionRepository.save(tax);
    return tax;
  }
  catch(HandleException f)
  {
    throw new HandleException("transaction failed to create");
  }
   
  }

  @Override
  public List<Transaction> generteTransactionReport(WrapperTransaction obj) {
 
    List<Transaction> TransactionList  = transactionRepository.findAll();
    
    List<Long> listforId=null;
    
    for(Transaction ts: TransactionList)
    {
      if(ts.getAccount().getAccountId().equals(obj.getAccount()))
      {
        listforId.add(ts.getTransactionId());
        TransactionList.add(ts.getTransactionId())
      }
    }
    
    
    return null;
  }

}
