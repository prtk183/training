package com.sbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.AccountRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.dao.TransactionRepository;
import com.sbank.model.Account;
import com.sbank.model.Customer;
import com.sbank.model.Transaction;
import com.sbank.wrappers.WrapperTransaction;

@Service
public class TransactionServiceImpl implements TransactionService{

  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private CustomerRepository customerrepository;
  @Autowired
  private TransactionRepository transactionRepository;
  
  @Override
  public Transaction createTransaction(WrapperTransaction obj) {
    
    Transaction tax=null;
    
    Account act = accountRepository.findById(obj.getAccount()).get();
    
    Customer cust = customerrepository.findById(obj.getCustomerId()).get();
    
    String ttype= obj.getTtype();
    
    tax.setAccount(act);
    tax.setCustomer(cust);
    tax.setTransactionType(ttype);
    tax.setAmount(obj.getAmount());
    
    tax=transactionRepository.save(tax);
    
    return tax;
  }

  @Override
  public List<Transaction> generteTransactionReport(WrapperTransaction obj) {
    // TODO Auto-generated method stub
    
    
    return null;
  }

}
