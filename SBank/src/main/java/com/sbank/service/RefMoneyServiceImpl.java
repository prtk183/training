package com.sbank.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.dao.RefMoneyRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.RefMoney;

@Service
public class RefMoneyServiceImpl implements RefMoneyService{

  @Autowired
  RefMoneyRepository refMoneyRepository;
  
  Logger log = Logger.getLogger(RefMoneyServiceImpl.class.getName());

  @Override
  public RefMoney update(RefMoney refMoney) throws HandleException{
    
   
    log.info("in ref update ");
    return  refMoneyRepository.save(refMoney);
  }
  @Override
  public RefMoney getRef(Long refId) throws HandleException {

    
    log.info("in ref get ref update ");
    return refMoneyRepository.findById(refId).get();
  }

}
