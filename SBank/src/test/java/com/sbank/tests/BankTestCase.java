/*package com.sbank.tests;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.sbank.SBankApplication;
import com.sbank.controller.BankController;
import com.sbank.model.Bank;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankTestCase {

 
  @Autowired
  private MockMvc mockMvc;
  
   SBankApplication sbankApplication = new SBankApplication();
  
  @Test
  public void checkBankCreation() throws Exception
  {
    BigDecimal amount = new BigDecimal(0);
            this.mockMvc.perform(post("/createbank"))
            .body(amount).andDo(print()).andExpect(status().isOk());
            
            this.mockMvc.perform(post("/createbank")).contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
            .body(IntegrationTestUtil.convertObjectToJsonBytes(amount)).andDo(print()).andExpect(status().isOk());
    
  }
  
  @Test
  public void checkGetDetails()
  {
    ResponseEntity<List<Bank>> allBanks=  bankController.getBankDetails();
    
   int num = allBanks.getBody().size();
    
    assertEquals("equals Record found",num,1);
    
  }
  
}
*/