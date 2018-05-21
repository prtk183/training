package com.sbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbank.model.Account;
import com.sbank.model.RefMoney;

public interface RefMoneyRepository extends JpaRepository<RefMoney, Long>{

}
