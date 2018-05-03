package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Customer;
import model.Retailer;

import repository.CustomerDAOImpl;
import repository.GoodsDAOImpl;
import repository.RetailerDAO;
import repository.RetailerDAOImpl;
import repository.SupplierDAOImpl;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.GoodsService;
import service.RetailerService;
import service.SupplierService;
import service.SupplierServiceImpl;


public class ContollerMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


		 CustomerService dao= context.getBean("cdao",service.CustomerServiceImpl.class);  
		/*
		Customer c = new Customer(103,"Peter","YZK","debit card");
		   
		 int status=dao.addCustomer(c);  
		    System.out.println(status); 
	 */
		 /*
	   int status1=dao.updateCustomer(103,"Robert"); 
	    System.out.println(status1); 
		     
	  */
		 /*
		    int status2=dao.removeCustomer(103); 
		
		    System.out.println(status2); 
		
		*/
		
		 GoodsService gdao = (GoodsService) context.getBean("gdao");		
		
		
		 //@ add goods
	/*	 int status3 = gdao.addGoods(12, "Doodle", 5, 50.12);
		 System.out.println(status3);
		 
		 int status4 = gdao.addGoods(13, "Soap", 5, 250.12);
		 System.out.println(status4);
		
		
	*/
		 //@remove goods
		// int status14 = gdao.removeGoods(12);
		// System.out.println(status14);
		
	 
		 
		//@update goods
		// int status5 = gdao.updateGoods(13,"Pen");
		// System.out.println(status5);
		 
		
		 
		 SupplierService sdao =(SupplierServiceImpl) context.getBean("sdao");		//goods bean + jdbc template
		 
		
		 //@ add supplier
		 //int status6 = sdao.addSupplier(22, "rat", "xyz", 12, 211, 21211.2);
		 //System.out.println(status6);
		 


		 //@remove supplier
		// int status7 = sdao.removeSupplier(21);
		// System.out.println(status7);
		
		 
		 
		 
		 
		//@update supplier
		
		 
		 //int status8 = sdao.updateSupplier(22, "Prateek ", "dhdasvati", 121, 211, 2011.2);
		 //int status8 = sdao.updateSupplier(22, "Prateek ");
		// System.out.println(status8);
		 
		
		    
		RetailerService rdao =(RetailerService) context.getBean("rdao");
		
		
		
			 //@ add supplier
		// int status9 = rdao.addRetailer("hdydy","lalaland");
		 //System.out.println(status9);
		 
		
		
		rdao.viewCustomer(106);
		rdao.getAllGoods();
		rdao.viewSupplier(22);
		

	}

}
		
	
		
		
		
		

