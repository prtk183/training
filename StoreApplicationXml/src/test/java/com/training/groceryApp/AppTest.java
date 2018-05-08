package com.training.groceryApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import controller.ContollerMain;
import model.Customer;
import model.Retailer;
import model.Supplier;
import repository.CustomerDAOImpl;
import repository.GoodsDAOImpl;
import service.CustomerServiceImpl;
import service.GoodsServiceImpl;

/**
 * Unit test for simple Application.
 */
public class AppTest {

	GoodsServiceImpl testGoods;
	
	/*configuring xml*/
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Autowired
	JdbcTemplate jt = context.getBean("jdbcTemplate", JdbcTemplate.class);
	
	CustomerServiceImpl testCustomer = context.getBean("cdao", CustomerServiceImpl.class);


/*
 * validating retalier
 * */
	@Test
	public void checkForNull() {
		String retailerName = null;
		String retailerAddress = null;

		Retailer retailer = new Retailer("Spectre Litt", "NY");
		assertNotEquals("Enter valid Name", retailerName, retailer.getRetailerName());

		assertNotEquals("Enter valid address", retailerAddress, retailer.getRetailerAddres());
	}
	
	
	/*
	 * validating customer
	 * */
	@Test
	public void checkForNullCustomer() {

		String customerId = null;
		String customerName = null;
		String customerAddress = null;
		String paymentMode = null;
		

		Customer customer = new Customer(1, "rama", "wardhaa", "debitcard");
		assertNotEquals("Enter valid id", customerId, customer.getCustomerId());
		assertNotEquals("Enter valid name", customerName, customer.getCustomerName());
		assertNotEquals("Enter valid address", customerAddress, customer.getCustomerAddress());
		assertNotEquals("Enter valid paymentMode", paymentMode, customer.getPaymentMode());
	}

	/*
	 * validating supplier
	 * */
	@Test
	public void checkForNullSupplier() {
	
	String supplierId = null;
	String supplierName = null;
	String supplierAddress = null;
	int quantityOrder = 0;
	int orderId = 0;
	double amount = 0;

	Supplier supplier = new Supplier(1, "Jessica", "10th Street", 2, 1, 1990.00);
	assertNotEquals("Enter valid name", supplierName, supplier.getSupplierName());
	assertNotEquals("Enter valid nsupplier address", supplierAddress, supplier.getSupplierAddress());
	assertNotEquals("Enter valid quantity", quantityOrder, supplier.getQuantityOrder());
	assertNotEquals("Enter valid Id", orderId, supplier.getOrderId());
	assertNotEquals("Enter valid amount", amount, supplier.getAmount());
}
	
//customer methods	
	
	
	@Test
	public void checkAddCustomerSucccess()
	{
		Customer customer1 = new Customer(102, "Thesha","Thiruv","jdki");
		int i;
		i=testCustomer.addCustomer(customer1);
		assertEquals("Added Sucessfully",1,i);
	}
	
	@Test
	public void checkAddCustomerFailure()
	{
		Customer customer1 = new Customer(102, "Thesha","Thiruv","jdki");
		int i;
		i=testCustomer.addCustomer(customer1);
		assertNotEquals("Added Sucessfully",0,i);
	}
	/*
	 * checking removal of customer
	 * */
	@Test
	public void checkRemoveCustomerSuccess()
	{

		int i =0;
		i=testCustomer.removeCustomer(103);
		

		assertEquals("Removed Successfully",1,i);
	
	}
	
	@Test
	public void checkRemoveCutomerFailure()
	{
		
		int i =0;
		i=testCustomer.removeCustomer(103);
		

		assertEquals("can not be removed",0,i);
	
		
	}

	
	/*
	 * 
	 * 
	 * */
	
}
