package service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Customer;
import model.Goods;
import model.Retailer;
import model.Supplier;
import repository.RetailerDAO;

@Service("retailerService")
public class RetailerServiceImpl implements RetailerService{

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
	public RetailerDAO retailerDAO;

	public RetailerDAO getRetailerDAO() {
		return retailerDAO;
	}

	public void setRetailerDAO(RetailerDAO retailerdao) {
		this.retailerDAO = retailerdao;
	}


	
	@Override
	public void getAllGoods() {
		// TODO Auto-generated method stub
		List<Goods> String=retailerDAO.viewGoods();
		
		
	}

	@Override
	public void viewCustomer(int id) {
		// TODO Auto-generated method stub
		List<Customer> cust =retailerDAO.viewCustomer(id);
		
	}

	@Override
	public void viewSupplier(int id) {
		// TODO Auto-generated method stub
		List<Supplier> supp=retailerDAO.viewSupplier(id);
		
	}
	
	public int addRetailer(String name, String add)
	{
		int rtl = retailerDAO.addRetailer(name, add);
		return rtl;
	}

}
