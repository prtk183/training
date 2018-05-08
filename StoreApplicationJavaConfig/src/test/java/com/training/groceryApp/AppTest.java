package com.training.groceryApp;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import model.Customer;
import model.Retailer;
import model.Supplier;
import repository.CustomerDAOImpl;
import repository.GoodsDAOImpl;

/**
 * Unit test for simple Application.
 */
public class AppTest {

	CustomerDAOImpl testAddCustomer;
	GoodsDAOImpl testGoods;

/**
 * 
 * to validate retailer*/

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

	Supplier supplier = new Supplier(1, "Payla", "10th Street", 2, 1, 1990.00);
	System.out.println(supplier.getSupplierName());
	assertNotEquals("Enter valid name", supplierName, supplier.getSupplierName());
	assertNotEquals("Enter valid address", supplierAddress, supplier.getSupplierAddress());
	assertNotEquals("Enter valid quantity", quantityOrder, supplier.getQuantityOrder());
	assertNotEquals("Enter valid Id", orderId, supplier.getOrderId());
	assertNotEquals("Enter valid amount", amount, supplier.getAmount());
}
	

}
