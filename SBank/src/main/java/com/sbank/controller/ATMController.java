package com.sbank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbank.dao.ATMRepository;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.model.Account;
import com.sbank.model.Bank;
import com.sbank.service.ATMService;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;

@Controller
public class ATMController {

  @Autowired
  ATMService ATMService;
 
  @Autowired
  com.sbank.service.ATMServiceImpl ATMServiceImpl;
  /*
   * this will call create atm in service
   * with arguments as bankid and its own details
   * */
  @PostMapping("/createatm")
  public ResponseEntity<ATM> callcreateATM(@RequestBody WrapperATMCreate object) throws HandleException
  {
    ATM atm = new ATM();
    
 
    atm = ATMServiceImpl.createATM(object);
    
    return new ResponseEntity<ATM>(atm,HttpStatus.OK);
  }
  
  /*
   * to add money from bank
   * */
  @PostMapping("/addmoneyfrombank")
  public ResponseEntity<ATM> calladdMoneyFromBank(@RequestBody WrapperATMAddMoneyToATM object) throws HandleException
  {
    ATM atm = new ATM();

    atm = ATMServiceImpl.addMoneyFromBank(object);
    return new ResponseEntity<ATM>(atm,HttpStatus.OK);
  }
 
  /*
   * 
   * call withdraw service
   * */
  @PostMapping("/withdrawmoney")
  public ResponseEntity<ATM> callwithdrawMoney(@RequestBody WrapperATMWithdraw object) throws HandleException
  {
    ATM atm = new ATM();

    atm = ATMServiceImpl.withdrawMoney(object);
    return new ResponseEntity<ATM>(atm,HttpStatus.OK);
  }
}
