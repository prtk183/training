package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;
import com.sbank.wrappers.WrapperTransaction;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Bank;
import com.sbank.model.Customer;
import com.sbank.model.Transaction;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  CustomerServiceImpl customerServiceImpl;
  @Autowired
  BankServiceImpl bankServiceImpl;
  @Autowired
  AccountRepository accountRepository;
  @Autowired
  TransactionServiceImpl transactionServiceImpl;

  /**/
  /* creating an account
   * @see com.sbank.service.AccountService#createAccount(com.sbank.wrappers.CreateAccountWrapper)
   */
  @Override
  public Account createAccount(CreateAccountWrapper object) throws HandleException {
   
    Account account = new Account(); 
 

      if (customerServiceImpl.getCustomer(object.getCustomerId()).getCustomerId().equals(object.getCustomerId())    //tracing bank and account whether it exist or else throw error
            &&  bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId()))
            {   
        
                account.setAmount(object.getAmount());
                Customer cust = customerServiceImpl.getCustomer(object.getCustomerId());                                                        
                account.setCustomer(cust);
                Bank bank = bankServiceImpl.getBank(object.getBankId());
                account.setBank(bank); 

                BigDecimal initial = bank.getAmount();
                BigDecimal updated = initial.add(object.getAmount());

                bank.setAmount(updated);
                bankServiceImpl.updateBank(bank);
                account = accountRepository.save(account); 
            } else {

        throw new HandleException("Bank or customer id is not valid"); // if bank or customer is not found
      }
    return account;
  }

  /*
   * get account details of all account
   * @see com.sbank.service.AccountService#getAccountDetails()
   */
  @Override
  public List<Account> getAccountDetails() throws HandleException {
    // TODO Auto-generated method stub
    List<Account> accountList = null;
    accountList = accountRepository.findAll();
    return accountList;
  }

  
  /*
   * @parameters: object containing customerid, bankid, accountid and amount to deposit
   * @return: updated account
   * */
  @Override
  public Account depositeMoney(WrapperAccountDeposite object) throws HandleException {
    // TODO Auto-generated method stub
    Account act = null;
    
      if (customerServiceImpl.getCustomer(object.getCustomerId()).getCustomerId().equals(object.getCustomerId())
          && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())) {   //checking valid customer and bank
       
          Bank bank =  bankServiceImpl.getBank(object.getBankId());
          act = accountRepository.findById(object.getAccountId()).get();
        
          BigDecimal val = new BigDecimal(100);
          BigDecimal initialamountinaccount = act.getAmount();
          BigDecimal initialamountinbank = bank.getAmount();
            
          if(object.getAmount().compareTo(val)==1){
              BigDecimal updatedbank = initialamountinbank.add(object.getAmount()); // adding depositing into bank
              BigDecimal updatedact = initialamountinaccount.add(object.getAmount()); // adding depositing in account
              
              

              act.setAmount(updatedact);
              bank.setAmount(updatedbank);
              String transactionType="DEPOSIT";
              
              WrapperTransaction Obj = new  WrapperTransaction(object.getCustomerId(), 
                  object.getAccountId(), transactionType, object.getAmount());
              
              Transaction transaction = transactionServiceImpl.createTransaction(Obj);
       
              accountRepository.saveAndFlush(act);
              bankServiceImpl.updateBank(bank);
              }
          else{
              throw new HandleException("amount can not be lesss than 100");
          }
      } 
      else {
        throw new HandleException("Data is incorret");
      }

    return act;

  }

  /**/
  /*withdraw money from atm--bank--account
   * @see com.sbank.service.AccountService#withdrawMoney(com.sbank.wrappers.WrapperAccountDeposite)
   */
  @Override
  public Account withdrawMoney(WrapperAccountDeposite object) throws HandleException {
    Account act = null;

      if (bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())
          && accountRepository.findById(object.getAccountId()).isPresent()) {
        
          Bank bank = bankServiceImpl.getBank(object.getBankId());
          act = accountRepository.findById(object.getAccountId()).get();

          BigDecimal initialamountinaccount = act.getAmount();
          BigDecimal validamount = new BigDecimal(100);
        
            if((object.getAmount().compareTo(initialamountinaccount)==-1 || object.getAmount().compareTo(initialamountinaccount)==0)
                && object.getAmount().compareTo(validamount)==1){
                  BigDecimal updatedact = initialamountinaccount.subtract(object.getAmount()); // withdrawing
                                                                          // substracting in account
                 act.setAmount(updatedact);
                 
                 String transactionType="Withdraw";
                 
                 WrapperTransaction Obj = new  WrapperTransaction(object.getCustomerId(), 
                     object.getAccountId(), transactionType, object.getAmount());
                 
                 Transaction transaction = transactionServiceImpl.createTransaction(Obj);
          
                 
                 accountRepository.saveAndFlush(act);
            } else {
                throw new HandleException("withdrwa amount is not valid");
            }
        
        
        BigDecimal initialamountinbank = bank.getAmount();
 
            if (initialamountinbank.compareTo(validamount) == 1 && object.getAmount().compareTo(initialamountinbank)==-1
                && object.getAmount().compareTo(validamount)==1) {

                BigDecimal updatedbank = initialamountinbank.subtract(object.getAmount()); // withdrawing into bank
                bank.setAmount(updatedbank);
                bankServiceImpl.updateBank(bank);

            } else {
            throw new HandleException("insufficeiant ammount");
            }
      } else {
      throw new HandleException("bankid or acounid is not valid");
      }

    return act;

  }

  /*
   * @parameter long account id
   * @return account
   * */
  @Override
  public Account getAccountDetail(Long Id) throws HandleException  {

    return  accountRepository.findById(Id).get();
  
  }

  /*@parameter account
   *
   * */
  @Override
  public void updateAccount(Account account) throws HandleException {

    Optional op;

    op = accountRepository.findById(account.getAccountId());
    if(op.isPresent())
    {
       account = accountRepository.saveAndFlush(account);
   
    }
    else
    {
      throw new HandleException("could not update account details");
    }
    
  }

}
