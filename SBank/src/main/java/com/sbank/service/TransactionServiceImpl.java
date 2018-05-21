package com.sbank.service;

import java.util.ArrayList;
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
  
  /**/
  /* create transaction
   * @see com.sbank.service.TransactionService#createTransaction(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public Transaction createTransaction(WrapperTransaction obj) throws HandleException {
    
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
        
             throw new HandleException("customer not found");
           }
    }  else {
      throw new HandleException("account not found");
    }
  }

  /**/
  /* generating report for an id
   * @see com.sbank.service.TransactionService#generteTransactionReport(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public List<Transaction> generteTransactionReport(Long accountId) throws HandleException {
 
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
      throw new HandleException("no record found");
    }
    else
    {
       return TransactionReportForById;
    }
  }

  @Override
  public Transaction getTransaction(Long transactionId) throws HandleException {

    Transaction Tax = transactionRepository.findById(transactionId).get();
    return Tax;
  }

}
