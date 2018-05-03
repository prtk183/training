package service;

public interface RetailerService {

	public void getAllGoods();
	
	public void viewCustomer(int id);
	
	public void viewSupplier(int id);
	
	public int addRetailer(String name, String add);
}
