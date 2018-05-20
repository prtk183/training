package com.sbank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.ATMRepository;
import com.sbank.dao.AtmDenominationRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Atm_Denomination;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class AtmDenominationImpl implements AtmDenominationService{
  
  @Autowired
  AtmDenominationRepository atmDenominationRepository;
  
  @Autowired
  ATMService atmService;

  @Override
  public Atm_Denomination giveDenomination(Long atmId, BigDecimal requestAmount) throws HandleException{
    
   //case 1 i have 2000, 500, 200, 100
    
   Map<Integer, Integer> noofdenom = new HashMap<Integer, Integer>();
   List<Integer> denomination = new ArrayList<Integer>();
   denomination.add(2000);
   denomination.add(500);
   denomination.add(200);
   denomination.add(100);

    if(atmService.getAtm(atmId).getATMId().equals(atmId))
    {
      BigDecimal amount = requestAmount;

        //System.out.println(amount.remainder(new BigDecimal(2)).equals(new BigDecimal(0)));
      System.out.println("in denomination");
        System.out.println(amount.compareTo(new BigDecimal(100)));
        if(amount.remainder(new BigDecimal(2)).equals(new BigDecimal(0)) && amount.compareTo(new BigDecimal(100))==1)
        {
            System.out.println("in comarision");
            BigDecimal twothousand = new BigDecimal(2000);
            //BigDecimal thowthousandcount=new BigDecimal(0);
            Integer thowthousandcount=0;
            BigDecimal fivehundres = new BigDecimal(500);
            //BigDecimal fivehundredcount=new BigDecimal(0);
            Integer fivehundredcount = 0;
            BigDecimal twohundred = new BigDecimal(200);
           // BigDecimal thwohundredcount = new BigDecimal(0);
            Integer thwohundredcount = 0;
            BigDecimal hundred = new BigDecimal(100);
            //BigDecimal hundredcount = new BigDecimal(0);
            Integer hundredcount=0;
            System.out.println(amount);
            System.out.println(amount.intValue());
            int take = amount.intValue();
            while(take!=0)
            {
              System.out.println("in loop");
            
              if(take>=2000)
              {
                thowthousandcount=take/2000;
                take=take%2000;
              }
              else if(take>=500)
              {
                fivehundredcount=take/500;
                take=take%500;
                System.out.println("500k "+fivehundredcount);
                
              }
              else if(take>=200)
              {
                thwohundredcount=take/200;
                take=take%200;
                System.out.println("200K"+thwohundredcount);
              }
              else if(take>=100)
              {
                hundredcount=take/100;
                take=take%100;
                System.out.println("100k"+hundredcount);
              }
              else if(take<100)
              {
                throw new HandleException("invalid amount");
              }
              
              
              /*System.out.println("in loop");
                if(amount.compareTo(twothousand)==1 && amount.compareTo(twothousand)==0)
                  {
                      thowthousandcount = amount.divide(twothousand);
                      amount = amount.remainder(twothousand);
                      System.out.println("in 2000");
                      System.out.println(thowthousandcount);
                      System.out.println(amount);

                      
                   }
                  else if(amount.compareTo(twothousand)==-1 && amount.compareTo(fivehundres)==1 && amount.compareTo(fivehundres)==0)
                      {
                        fivehundredcount=amount.divide(fivehundres);
                        amount=amount.remainder(fivehundres);
                        System.out.println("in 500");
                        System.out.println(fivehundredcount);
                        System.out.println(amount);
                       
                      }
                      else if (amount.compareTo(fivehundres)==-1 && amount.compareTo(twohundred)==1 && amount.compareTo(twohundred)==0)
                          {
                            thwohundredcount = amount.divide(twohundred);
                            amount = amount.remainder(twohundred);
                            System.out.println("in 200");
                            System.out.println(thwohundredcount);
                            System.out.println(amount);
                           
                          }
                          else if (amount.compareTo(twohundred)==-1 && amount.compareTo(hundred)==1 && amount.compareTo(hundred)==0)
                                {
                                    hundredcount = amount.divide(hundred);
                                    amount = amount.remainder(hundred);
                                    System.out.println("in 100");
                                    System.out.println(hundredcount);
                                    System.out.println(amount);
                                }
                              else if(amount.compareTo(hundred)==-1)
                              {
                                throw new HandleException("not valid amount");
                              }
            */
              
            }
 

            noofdenom.put(2000, thowthousandcount);
            noofdenom.put(500, fivehundredcount);
            noofdenom.put(200, thwohundredcount);
            noofdenom.put(100, hundredcount);
            
            Atm_Denomination atmobject = new Atm_Denomination(atmId, requestAmount, denomination, noofdenom);
            atmDenominationRepository.save(atmobject);
            return atmobject;
            
        } else {
          throw new HandleException("amount is odd, enter valid amount in denomination");
        }
      
    } else {
      throw new HandleException("Atm is not valid");
    }
    
    
   
  }

}
