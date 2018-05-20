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
import com.sbank.model.Atm_Denomination;
import com.sbank.model.Bank;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;

/**
 * @author hp
 *
 */
@Service
public class ATMServiceImpl implements ATMService {

  @Autowired
  BankServiceImpl bankServiceImpl;
  @Autowired
  ATMRepository atmrepository;
  @Autowired
  AccountServiceImpl accountServiceImpl;
  
  @Autowired
  AtmDenominationImpl atmDenominationImpl;

  /*
   * @parameter amount and bankid
   * @return atm
   * @see com.sbank.service.ATMService#createATM(com.sbank.wrappers.WrapperATMCreate)
   */
  @Override
  public ATM createATM(WrapperATMCreate object) throws HandleException {

    ATM atm = new ATM();

    atm.setAmount(object.getAmount());
    atm.setBank(bankServiceImpl.getBank(object.getBankId()));

    atm = atmrepository.save(atm);

    return atm;
  }

  /*
   * requesting amount to bank and transfering to atm
   * @see com.sbank.service.ATMService#addMoneyFromBank(com.sbank.wrappers.WrapperATMAddMoneyToATM)
   */
  @Override
  public ATM addMoneyFromBank(WrapperATMAddMoneyToATM object) throws HandleException {

    if (atmrepository.findById(object.getAtmID()).isPresent()
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())) //validating input data
    {
      ATM atm = atmrepository.findById(object.getAtmID()).get();
      atm.setAmount(atm.getAmount().add(object.getAmount()));
      atm.setBank(bankServiceImpl.getBank(object.getBankId()));

      Bank bank = bankServiceImpl.getBank(object.getBankId());

      BigDecimal bankamount = bank.getAmount();
      BigDecimal validamount = new BigDecimal(100);

        if (object.getAmount().compareTo(bankamount) == -1
            && object.getAmount().compareTo(validamount) == 1) // checking for valid amount transefer request
          {
               bank.setAmount(bank.getAmount().subtract(object.getAmount()));
               bankServiceImpl.updateBank(bank);
               atm = atmrepository.save(atm);
               return atm;

          } else {
              throw new HandleException("invalid amount transfer request");
                  }
    } else {
      throw new HandleException("invalid data");
    }

  }

  /* requesting an amount validating acrross atm - bank- account and accepting it
   * @see com.sbank.service.ATMService#withdrawMoney(com.sbank.wrappers.WrapperATMWithdraw)
   */
  @Override
  public ATM withdrawMoney(WrapperATMWithdraw object) throws HandleException {
      
    if(atmrepository.findById(object.getAtmId()).isPresent() 
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())
        && accountServiceImpl.getAccountDetail(object.getAccountId()).getAccountId().equals(object.getAccountId()))   //validating the data
         {
            ATM atm = atmrepository.findById(object.getAtmId()).get();
            BigDecimal initial = new BigDecimal(100);
            BigDecimal validamount = new BigDecimal(100);
            if(object.getAmount().compareTo(atm.getAmount())==-1 && object.getAmount().compareTo(validamount)==1)   //validating request wrt to atm
            {
                atm.setAmount(atm.getAmount().subtract(object.getAmount())); 
                Bank bank = bankServiceImpl.getBank(object.getBankId());
                
                if((object.getAmount().compareTo(bank.getAmount())==-1) &&
                    (object.getAmount().compareTo(validamount))==1) //validating the requested amount wrt bank                                                                                             //against money in atm
                {
                  
                  
                  Account account = accountServiceImpl.getAccountDetail(object.getAccountId());

                      if((object.getAmount().compareTo(account.getAmount())==-1 || object.getAmount().compareTo(account.getAmount())==0)
                          && object.getAmount().compareTo(validamount)==1 )   //validating wrt to account
                          {
                            account.setAmount(account.getAmount().subtract(object.getAmount()));
                                                       
                            Atm_Denomination permission = atmDenominationImpl.giveDenomination(object.getAtmId(), object.getAmount());
                            
                            if(permission.getPermission()==true)
                            {
                           
                              /*when all validation is succesfull, saving into corresponding tables*/
                              accountServiceImpl.updateAccount(account);
                            
                              atmrepository.save(atm);

                            return atm;
                            }
                            else
                            {
                              throw new HandleException("Enter amount as per valid denomination"); 
                            }
                       } else {
                                 throw new HandleException("requested amount denied by account , enter valid amount");
                      }
                   
                } else {
                          throw new HandleException("requested amount is denied by bank, enter valid amount");
                }
            } else {
              throw new HandleException("requested amount is denied by atm, enter valid amount");
            }
         } else {
                 throw new HandleException("Invalid data");

         }
    
  }

  @Override
  public ATM getAtm(Long atmId) throws HandleException {
    
    
    return (atmrepository.findById(atmId)).get();
  }

}
