package service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Customer;
import model.Goods;
import model.Retailer;
import model.Supplier;
import repository.RetailerDAO;

public class RetailerServiceImpl implements RetailerService{

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
