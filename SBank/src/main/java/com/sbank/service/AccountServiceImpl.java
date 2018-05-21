package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;

import com.sbank.wrappers.BankPermission;
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

  private Logger log = Logger.getLogger(AccountServiceImpl.class.getName());
  
  @Autowired
  Environment environment;
  @Autowired
  CustomerServiceImpl customerServiceImpl;
  @Autowired
  BankServiceImpl bankServiceImpl;
  @Autowired
  AccountRepository accountRepository;
  @Autowired
  TransactionServiceImpl transactionServiceImpl;
  @Autowired
  BankDenominationImpl bankdenominationImpl;
  @Autowired
  RefMoneyServiceImpl refMoneyServiceImpl;

  /**/
  /*
   * creating an account
   * 
   * @see com.sbank.service.AccountService#createAccount(com.sbank.wrappers.CreateAccountWrapper)
   */
  @Override
  @Transactional
  public Account createAccount(final CreateAccountWrapper object) throws HandleException {
    log.info(" in creating account");

    Account account = new Account();

    if (customerServiceImpl.getCustomer(object.getCustomerId()).getCustomerId()
        .equals(object.getCustomerId())
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())) {

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
      log.warning(environment.getProperty("301"));
      throw new HandleException("301"); // if bank or customer is not
                                                                     // found
    }
    return account;
  }

  /*
   * get account details of all account
   * 
   * @see com.sbank.service.AccountService#getAccountDetails()
   */
  @Override
  public List<Account> getAccountDetails() throws HandleException {
    // TODO Auto-generated method stub
    log.info(" in  getAccountDetails");
    List<Account> accountList = null;
    accountList = accountRepository.findAll();
    return accountList;
  }

  /*
   * @parameters: object containing customerid, bankid, accountid and amount to deposit
   * 
   * @return: updated account
   */
  @Override
  public Account depositeMoney(final WrapperAccountDeposite object) throws HandleException {
    // TODO Auto-generated method stub
    Account act = null;
    log.info(" in  depositeMoney");
    if (customerServiceImpl.getCustomer(object.getCustomerId()).getCustomerId()
        .equals(object.getCustomerId()) //// checking valid customer and bank
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())) {

      final Bank bank = bankServiceImpl.getBank(object.getBankId());
      act = accountRepository.findById(object.getAccountId()).get();

      final BigDecimal val = new BigDecimal(100);
      final BigDecimal initialamountinaccount = act.getAmount();
      final BigDecimal initialamountinbank = bank.getAmount();

      if (object.getAmount().compareTo(val) == 1) {
        BigDecimal updatedbank = initialamountinbank.add(object.getAmount()); // adding depositing
                                                                              // into bank

        BigDecimal updatedact = initialamountinaccount.add(object.getAmount()); // adding depositing
                                                                                // in account

        final BankPermission bpobject = new BankPermission();
        bpobject.setBankId(object.getBankId());
        bpobject.setRef(refMoneyServiceImpl.getRef(object.getRefId()));
        Boolean permmission = bankdenominationImpl.getDenominationPermission(bpobject);
        if (permmission == true) {
          act.setAmount(updatedact);
          bank.setAmount(updatedbank);
          String transactionType = "DEPOSIT";

          WrapperTransaction Object = new WrapperTransaction(object.getCustomerId(),
              object.getAccountId(), transactionType, object.getAmount());

          final Transaction transaction = transactionServiceImpl.createTransaction(Object);
          accountRepository.saveAndFlush(act);
          bankServiceImpl.updateBank(bank);
        }
      } else {
        
        throw new HandleException(environment.getProperty("302"));
      }
    } else {
     
      throw new HandleException(environment.getProperty("300"));
    }

    return act;

  }

  /**/
  /*
   * withdraw money from atm--bank--account
   * 
   * @see com.sbank.service.AccountService#withdrawMoney(com.sbank.wrappers.WrapperAccountDeposite)
   */
  @Override
  public Account withdrawMoney(final WrapperAccountDeposite object) throws HandleException {
    Account act = null;
    Bank bank = null;
    log.info(" in  withdrawMoney");
    if (bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())
        && accountRepository.findById(object.getAccountId()).isPresent()) {

      bank = bankServiceImpl.getBank(object.getBankId());
      act = accountRepository.findById(object.getAccountId()).get();

      BigDecimal initialamountinaccount = act.getAmount();
      BigDecimal validamount = new BigDecimal(100);

          if ((object.getAmount().compareTo(initialamountinaccount) == -1  || object.getAmount().compareTo(initialamountinaccount) == 0)
                && object.getAmount().compareTo(validamount) == 1) {
              final BigDecimal updatedact = initialamountinaccount.subtract(object.getAmount()); // withdrawing substracting in account
                act.setAmount(updatedact);

                  final String transactionType = "Withdraw";

                    WrapperTransaction Obj = new WrapperTransaction(object.getCustomerId(),
                    object.getAccountId(), transactionType, object.getAmount());

                      transactionServiceImpl.createTransaction(Obj);

                      accountRepository.saveAndFlush(act);
            } else {
     
                    throw new HandleException(environment.getProperty("303"));
                  }

      final BigDecimal initialamountinbank = bank.getAmount();

      if (initialamountinbank.compareTo(validamount) == 1
          && object.getAmount().compareTo(initialamountinbank) == -1
          && object.getAmount().compareTo(validamount) == 1) {

        BigDecimal updatedbank = initialamountinbank.subtract(object.getAmount()); // withdrawing
                                                                                   // into bank
        bank.setAmount(updatedbank);
        bankServiceImpl.updateBank(bank);

      } else {
        log.warning("");
        throw new HandleException(environment.getProperty("304"));
      }
    } else {
      log.warning("");
      throw new HandleException(environment.getProperty("305"));
    }

    return act;

  }

  /*
   * @parameter long account id
   * 
   * @return account
   */
  @Override
  public Account getAccountDetail(final Long Id) throws HandleException {
    log.info(" in  getAccountDetail");

    return accountRepository.findById(Id).get();

  }

  /*
   * @parameter account
   *
   */
  @Override
  public void updateAccount(Account account) throws HandleException {
    log.info(" in  updateAccount");

    Optional op;

    op = accountRepository.findById(account.getAccountId());
    if (op.isPresent())
    {
      account = accountRepository.saveAndFlush(account);

    } else {
    
      throw new HandleException(environment.getProperty("333"));
    }

  }

}
