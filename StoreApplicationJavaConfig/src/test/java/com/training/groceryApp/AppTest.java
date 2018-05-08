package com.training.groceryApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import controller.AppConfig;
import model.Customer;
import model.Retailer;
import model.Supplier;
import repository.CustomerDAO;
import repository.CustomerDAOImpl;
import repository.GoodsDAOImpl;
import service.CustomerService;

/**
 * Unit test for simple Application.
 */
public class AppTest {

	DataSource dataSource = new DriverManagerDataSource();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	CustomerDAO testCustomer= new CustomerDAOImpl(jdbcTemplate);
	
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	CustomerService cdao= context.getBean("customerService",service.CustomerServiceImpl.class); 
	
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
	//System.out.println(supplier.getSupplierName());
	assertNotEquals("Enter valid name", supplierName, supplier.getSupplierName());
	assertNotEquals("Enter valid address", supplierAddress, supplier.getSupplierAddress());
	assertNotEquals("Enter valid quantity", quantityOrder, supplier.getQuantityOrder());
	assertNotEquals("Enter valid Id", orderId, supplier.getOrderId());
	assertNotEquals("Enter valid amount", amount, supplier.getAmount());
}
	
/*
 *to test add customer 
 * */
	@Test
public void testAddCustomerSucces()
	{
		
	 final Customer c = new Customer(104,"sumya","mumbai","tooth");
	 int status=3;

	 status = cdao.addCustomer(c);
	 assertEquals("adding customer succeed",1, status);
	
	}
	
	@Test
public void testAddCustomerFailure()
	{
		
	 final Customer c = new Customer(104,"sumya","mumbai","tooth");
	 int status=3;
	 status = cdao.addCustomer(c);
	 assertNotEquals("adding customer failed",1, status);
	
	}


/*
 * update customer
 * */
	@Test
public void testUpdateCustomerSuccess() {

	   final int status1=cdao.updateCustomer(101,"Robertz"); 

		 assertEquals("update customer succeed",1, status1);

}
	@Test
public void testUpdateCustomerFailure() {

	   final int status1=cdao.updateCustomer(104,"Robert"); 

		 assertNotEquals("update customer failed",1, status1);

}

/*
 * remove customer
 * */
	@Test
public void testRemoveCustomerSuccess() {
	   
	final int status1=cdao.removeCustomer(104);
	   
		assertEquals("remove customer succeed",1, status1);

}

	@Test
public void testRemoveCustomerFailure() {
	   
	final int status1=cdao.removeCustomer(103);
	   
		assertNotEquals("remove customer failed",1, status1);

}
	
}
