package service;

import org.springframework.jdbc.core.JdbcTemplate;

import repository.SupplierDAO;

public class SupplierServiceImpl implements SupplierService {

	public SupplierDAO supplierDAO;
	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
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
