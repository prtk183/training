package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Customer;
import repository.CustomerDAO;


public class CustomerServiceImpl implements CustomerService {

	//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// CustomerDAO customerDAO = context.getBean("cdaor",repository.CustomerDAOImpl.class);  

	public CustomerDAO customerDAO;
	
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}



	@Override
	public int removeCustomer(int customerId) {

		//CustomerDAO customerDAO = null;
		int removeData = customerDAO.removeCustomer(customerId);
		return removeData;
	}

	@Override
	public int updateCustomer(int customerId, String customerName) {

		//CustomerDAO customerDAO = null;
		int updateData = customerDAO.updateCustomer(customerId, customerName);
		return updateData;
	}


	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		int adcustomer = customerDAO.addCustomer(customer);
		return adcustomer;
	}

}
