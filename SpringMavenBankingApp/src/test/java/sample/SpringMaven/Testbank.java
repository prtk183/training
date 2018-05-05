package sample.SpringMaven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import SpringBankingApp.Controller.OperatingMain;
import SpringBankingApp.DAO.DAOTransactionImpl;
import SpringBankingApp.Model.Address;
import SpringBankingApp.Model.Bank;
import SpringBankingApp.Model.Contact;
import SpringBankingApp.Model.Customer;
import SpringBankingApp.Model.SavingsAccount;
import SpringBankingApp.Model.Statement;

public class Testbank
{
	public static int count=100;
	OperatingMain om = new OperatingMain();
	
	DAOTransactionImpl dt = new DAOTransactionImpl();
	
	Map<Integer, Customer> CustomersMap = new HashMap<Integer, Customer>();
	Map<Integer, Contact> ContactsMap = new HashMap<Integer, Contact>();
	Map<Integer, SavingsAccount> accountsdetails = new HashMap<Integer, SavingsAccount>();
	Map<Integer, Bank> BanksMap = new HashMap<Integer, Bank>();
	Map<Integer, Statement> StatementsMap= new HashMap<Integer, Statement>();
	public 	Map<Integer, Address> AddressMap = new HashMap<Integer, Address>();



	
	@Test
	public void testBankCreationSuccess()
	{

	
		assertEquals(true,om.createBank("MyBank", CustomersMap, ContactsMap, accountsdetails, BanksMap));
		
	}
	

	
	
	@Test
	public void testgetDataSuccess()
	{
		++count;
		Address ad = new Address("jj road", "4895lp", "4578569", "DMN",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(5863.3, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("prtk", "GGawarle", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		
		String returnCity=null;
		returnCity=om.getCustomerDetails(count, "prtk", "SBI", CustomersMap, accountsdetails, ContactsMap);
		//System.out.println(returnCity);
		//assertEquals("DMN", returnCity);
		assertTrue(returnCity.equals("DMN"));
		
	}
	
	
	@Test
	public void testgetDataFailure()
	{
		++count;
		Address ad = new Address("jj road", "4895lp", "4578569", "DMN",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(5863.3, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("prtk", "GGawarle", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		
		String returnCity=null;
		returnCity=om.getCustomerDetails(100, "prtk", "SBI", CustomersMap, accountsdetails, ContactsMap);
		
		assertNotEquals("DMT", returnCity);
		
	}
	
	
	@Test
	public void testDepositeSuccess()
	{
		++count;
		double checkDeposit=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DMN",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(5863.3, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("prtk", "GGawarle", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		
		checkDeposit=om.deposit("prtk", 137.8, accountsdetails, "SBI", CustomersMap, StatementsMap);
		

		assertTrue(checkDeposit==6000.0);
	}
	
	
	@Test
	public void testDepositFailure()
	{
		++count;
		double checkDeposit=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DMN",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(5863.3, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("prtk", "GGawarle", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		
		checkDeposit=om.deposit("prtk", 137.8, accountsdetails, "SBI", CustomersMap, StatementsMap);
		
		assertNotEquals(8000,checkDeposit);
		//assertTrue(checkDeposit==8000.0);
	}
	
	@Test
	public void testWithdrawSuccess()
	{
		++count;
		double checkWithraw=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DMN",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(5500.0, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("prtik", "Gawarleji", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		
		checkWithraw=om.withdraw("prtik", 500.0, accountsdetails, "SBI", CustomersMap, StatementsMap);

		assertTrue(checkWithraw==5000.0);
	}
	
	
	@Test
	public void testWithdrawFailure()
	{
		++count;
		double checkWithraw=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DMN",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(5500.0, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("prtik", "Gawarleji", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		
		checkWithraw=om.withdraw("prtik", 500.0, accountsdetails, "SBI", CustomersMap, StatementsMap);

		assertNotEquals(5500.0,checkWithraw);
	}
	
	@Test
	public void testUpdateCustomerDetailsSuccess()
	{
		++count;
		double checkWithraw=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DSS",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(10000.0, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("Mahanji", "Gawarleji", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		boolean result;
		result=om.updateCustomerDetails("Mahanji", count, "Hanumanji", "Kailas", "myhanuman@gmail.com", 666666666L, CustomersMap, ContactsMap, AddressMap);
		assertEquals(true,result);
	}
	
	@Test
	public void testUpdateCustomerDetailsFailure()
	{
		++count;
		double checkWithraw=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DSS",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(10000.0, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("Mahanji", "Gawarleji", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		
	
		boolean result;
		result=om.updateCustomerDetails("Mahan", --count, "Hanumanji", "Kailas", "myhanuman@gmail.com", 666666666L, CustomersMap, ContactsMap, AddressMap);
		assertNotEquals(true,result);
	}
	
	@Test
	public void testDeleteAccountSuccess()
	{
		++count;
		double checkWithraw=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DSS",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(10000.0, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("Mahanji", "Gawarleji", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		boolean result;
		result=om.deleteAccount("Mahanji", count, CustomersMap, ContactsMap, BanksMap, accountsdetails, AddressMap);
		assertEquals(true,result);
	}
	
	@Test
	public void testDeleteAccountFailure()
	{
		++count;
		double checkWithraw=0.0;
		Address ad = new Address("jj road", "4895lp", "4578569", "DSS",count);
		AddressMap.put(count, ad);
		Contact ct  = new Contact(5895568L, 85989898L, "pg@email.com", ad, count);
		ContactsMap.put(count, ct);
		SavingsAccount act = new SavingsAccount(10000.0, 3.3, 2, CustomersMap, BanksMap);
		accountsdetails.put(count, act);
		Customer cus = new Customer("Mahanji", "Gawarleji", "SBI", count,
		 CustomersMap, accountsdetails,  ContactsMap, AddressMap);
		CustomersMap.put(count, cus);
		Date date = new Date();
		Statement st = new Statement( date, act, "new account");
		
		StatementsMap.put(count,st);
		boolean result;
		result=om.deleteAccount("Mahan", --count, CustomersMap, ContactsMap, BanksMap, accountsdetails, AddressMap);
		assertNotEquals(true,result);
	}
	
}