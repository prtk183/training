/**
 * 
 */
package com.sbank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.BankRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank;

/**
 * @author trainee
 *
 */
@Service
public class BankServiceImpl  implements BankService {


	
	@Autowired
	BankRepository bankrepository;
	
	@Override
	public Bank createBank(Bank bank) throws HandleException {
	  
	
	  Bank BankCustomer=null;
	  BigDecimal restrict = new BigDecimal(0);
	  if(bank.getAmount().compareTo(restrict)==-1)     //validating initial amount it can not be -ve
	  {
	    throw new HandleException("initial amount cannot be in -ve ");
	  }
	  else
	  {
		BankCustomer = bankrepository.save(bank);
		return BankCustomer;
	  }
	}

	@Override
	public List<Bank> getBankDetails() throws HandleException{
	
		List<Bank> bankslist = new ArrayList<Bank>();

		bankslist=bankrepository.findAll();
		if(bankslist.size()==0)
		{
		  throw new HandleException("no banks found");
		}

    return bankslist;
			
	
	}

  @Override
  public Bank getBank(BigDecimal bankId) throws HandleException {

    Optional op;
    Bank bank=null;
    op = bankrepository.findById(bankId);
    
    if(op.isPresent())
    {
      bank = bankrepository.findById(bankId).get();
      
    }
    
    return bank;
  }

	
	
}
