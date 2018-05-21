package com.sbank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
  
  @Autowired
  Environment environment;
  
  Logger log = Logger.getLogger(TransactionServiceImpl.class.getName());
  /**/
  /* create transaction
   * @see com.sbank.service.TransactionService#createTransaction(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public Transaction createTransaction(WrapperTransaction obj) throws HandleException {
    log.info("in trnsaction service createTransaction ");
    if(accountServiceImpl.getAccountDetail(obj.getAccount()).getAccountId().equals(obj.getAccount())) //validating account
    {
         Account account  = accountServiceImpl.getAccountDetail(obj.getAccount());
         
           if(customerServiceImpl.getCustomer(obj.getCustomerId()).getCustomerId().equals(obj.getCustomerId()))   //validating customer
           {
             Customer customer = customerServiceImpl.getCustomer(obj.getCustomerId());
             
             String ttype= obj.getTtype();
             Transaction tax= new Transaction();
    
             tax.setAccount(account);     
             tax.setCustomer(customer);
             tax.setTransactionType(ttype);
             tax.setAmount(obj.getAmount());
             
             tax=transactionRepository.save(tax); //saving 
             return tax;
   
           } else {
        
             throw new HandleException(environment.getProperty("501"));
           }
    }  else {
      throw new HandleException(environment.getProperty("502"));
    }
  }

  /**/
  /* generating report for an id
   * @see com.sbank.service.TransactionService#generteTransactionReport(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public List<Transaction> generteTransactionReport(Long accountId) throws HandleException {
    log.info("in trnsaction service generteTransactionReport");
    List<Transaction> TransactionList  = transactionRepository.findAll();
   
    List<Transaction> TransactionReportForById= new ArrayList<Transaction>();
    System.out.println(TransactionList);
    System.out.println("above loop");
  //  System.out.println("a+"+ts.getAccount().getAccountId());
    System.out.println("b+"+accountId);
    for(Transaction ts :TransactionList)
    {
      int i=0;
      if(ts.getAccount().getAccountId().equals(accountId))     //fetching transaction record for an account id
      {
    
            TransactionReportForById.add(transactionRepository.findById(ts.getTransactionId()).get());
    
      }
      System.out.println("yttreresdf"+i++);
    }
    System.out.println("totalList"+TransactionReportForById);
    if(TransactionReportForById.isEmpty())
    {
      throw new HandleException(environment.getProperty("500"));
    }
    else
    {
       return TransactionReportForById;
    }
  }

  @Override
  public Transaction getTransaction(Long transactionId) throws HandleException {
    log.info("in trnsaction service getTransaction");
    Transaction Tax = transactionRepository.findById(transactionId).get();
    return Tax;
  }

}
