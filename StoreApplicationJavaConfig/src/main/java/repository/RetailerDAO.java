/**
 * 
 */
package repository;

import java.util.List;

import model.Customer;
import model.Goods;
import model.Supplier;



public interface RetailerDAO {

	
	int addRetailer(String name, String address);
	
public  List<Goods> viewGoods();

public List<Customer>  viewCustomer(int customerId);

public  List<Supplier>  viewSupplier(int supplierId);
	
	
}
