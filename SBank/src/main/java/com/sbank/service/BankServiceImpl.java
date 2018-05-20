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
 * @author PrateekG
 *
 */
@Service
public class BankServiceImpl  implements BankService {


	
	@Autowired
	BankRepository bankrepository;
	
	/**/
	/* creating bank with amount which is in parameter
	 * @see com.sbank.service.BankService#createBank(com.sbank.model.Bank)
	 */
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

	/**/
	/* get all banks in form of list
	 * @see com.sbank.service.BankService#getBankDetails()
	 */
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

	/**/
  /* get the bank having particular bankid 
   * @see com.sbank.service.BankService#getBank(java.math.BigDecimal)
   */
  @Override
  public Bank getBank(Long bankId) throws HandleException {

    Optional op;
    Bank bank=null;
    op = bankrepository.findById(bankId);
    
    if(op.isPresent())
    {
      bank = bankrepository.findById(bankId).get(); 
    }
    return bank;
  }

  /**/
  /* update banks data
   * @see com.sbank.service.BankService#updateBank(com.sbank.model.Bank)
   */
  @Override
  public void updateBank(Bank bank) throws HandleException {
    // TODO Auto-generated method stub

    Optional op;
    op = bankrepository.findById(bank.getBankId());
    if(op.isPresent())
    {
      bankrepository.saveAndFlush(bank); 
    }
  }

	
	
}
