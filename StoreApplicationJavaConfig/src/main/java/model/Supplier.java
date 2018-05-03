package model;

import java.util.List;


public class Supplier {

	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	private int quantityOrder;
	private int orderId;
	private double amount;
	List<Goods> goodsList;

	
	public Supplier(int supplierId, String supplierName,
			String supplierAddress, int quantityOrder, int orderId,
			double amount, List<Goods> goodsList) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.quantityOrder = quantityOrder;
		this.orderId = orderId;
		this.amount = amount;
		this.goodsList = goodsList;
	}

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(int i, String string, String string2, int j, int k, double d) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.quantityOrder = quantityOrder;
		this.orderId = orderId;
		this.amount = amount;
	}

	
	public int getSupplierId() {
		return supplierId;
	}

	
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	
	public String getSupplierName() {
		return supplierName;
	}

	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	
	public String getSupplierAddress() {
		return supplierAddress;
	}

	
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	
	public int getQuantityOrder() {
		return quantityOrder;
	}

	
	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	
	public int getOrderId() {
		return orderId;
	}

	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	public double getAmount() {
		return amount;
	}

	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public List<Goods> getGoodsList() {
		return goodsList;
	}

	
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

}
