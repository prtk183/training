package service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import repository.SupplierDAO;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	public SupplierDAO supplierDAO;
	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

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

	@Override
	public int addSupplier(int supplierId, String supplierName,
			String supplierAddress, int quantityOrder, int orderId,
			double amount) {

		
		int addData = supplierDAO.addSupplier(supplierId, supplierName,
				supplierAddress, quantityOrder, orderId, amount);
		return addData;

	}

	@Override
	public int removeSupplier(int supplierId) {
		//SupplierDAO supplierDAO = null;
		int removeData = supplierDAO.removeSupplier(supplierId);
		return removeData;
	}

	@Override
	public int updateSupplier(int supplierId, String supplierName) {
		//SupplierDAO supplierDAO = null;
		int removeData = supplierDAO.updateSupplier(supplierId, supplierName);
		return removeData;
	}

}
