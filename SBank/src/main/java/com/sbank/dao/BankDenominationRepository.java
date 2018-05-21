package com.sbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbank.model.Atm_Denomination;
import com.sbank.model.Bank_Denomination;

public interface BankDenominationRepository extends JpaRepository<Bank_Denomination, Long>{



}
