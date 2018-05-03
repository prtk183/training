package service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Customer;
import repository.CustomerDAO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// CustomerDAO customerDAO = context.getBean("cdaor",repository.CustomerDAOImpl.class);  
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
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
