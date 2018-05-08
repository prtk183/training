/**
 * 
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import model.Customer;
import model.Goods;
import model.Retailer;
import model.Supplier;


@Repository()
@Qualifier("retailerDAO")
public class RetailerDAOImpl implements RetailerDAO {

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*@Override
	public int viewGoods() {
		// TODO Auto-generated method stub
		String query = "select * from goods";
		System.out.println(query);
		return jdbcTemplate.update(query);

	}*/

	
	public List<Goods> viewGoods(){  
		 return jdbcTemplate.query("select * from goods",new ResultSetExtractor<List<Goods>>(){  
		    @Override  
		     public List<Goods> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Goods> list=new ArrayList<Goods>();  
		        while(rs.next()){  
		        Goods e=new Goods();  
		        e.setGoodsId(rs.getInt(1));  
		        e.setGoodsName(rs.getString(2));  
		        e.setGoodsQuantity(rs.getInt(3));
		        e.setGoodsPrice(rs.getInt(4));
		        list.add(e); 
		        System.out.println(e.getGoodsName());
		        System.out.println(e.getGoodsPrice());
		        System.out.println(e.getGoodsQuantity());
		       
		        
		        }  
		        
		        return list;  
		        }  
		    });  
		  }  

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Customer> viewCustomer(int customerId) {
		
		String query = "select * from customer where customerId=" + customerId;
		System.out.println(query);
		 return jdbcTemplate.query(query,new ResultSetExtractor<List<Customer>>(){  
			    @Override  
			     public List<Customer> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Customer> list=new ArrayList<Customer>();  
			        while(rs.next()){  
			        Customer c=new Customer(); 
			        c.setCustomerAddress(rs.getString(3));
			       c.setCustomerId(rs.getInt(1));
			       c.setCustomerName(rs.getString(2));
			       c.setPaymentMode(rs.getString(4));
			        list.add(c); 
			        System.out.println(c.getCustomerId());
			        System.out.println(c.getCustomerName());
			        System.out.println(c.getCustomerAddress());
			        System.out.println(c.getPaymentMode());
			       
			        
			        }  
			        
			        return list;  
			        }  
			    });  

	}

	@Override
	public List<Supplier> viewSupplier(int supplierId) {
		String query = "select * from supplier where supplierId=" + supplierId;
		System.out.println(query);
		 return jdbcTemplate.query(query,new ResultSetExtractor<List<Supplier>>(){  
			    @Override  
			     public List<Supplier> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Supplier> list=new ArrayList<Supplier>();  
			        while(rs.next()){  
			        	Supplier c=new Supplier(); 
			        c.setSupplierId(rs.getInt(1));
			       c.setSupplierName(rs.getString(2));
			       c.setSupplierAddress(rs.getString(3));
			       c.setQuantityOrder(rs.getInt(4));
			       c.setOrderId(rs.getInt(5));
			       c.setAmount(rs.getDouble(6));
			        list.add(c); 
			        System.out.println(c.getSupplierId());
			        System.out.println(c.getSupplierName());
			        System.out.println(c.getSupplierAddress());
			        System.out.println(c.getQuantityOrder());
			        System.out.println(c.getOrderId());
			        System.out.println(c.getAmount());
			       
			        
			        }  
			        
			        return list;  
			        }  
			    });  

	
	}



	@Override
	public int addRetailer(String name, String address) {
		
		String query = "insert into retailer values ("+ "'"+name+"'"+","+"'" + address +"'"+")";
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method 
			
			String query = "select * from customer";
			System.out.println(query);
			 return jdbcTemplate.query(query,new ResultSetExtractor<List<Customer>>(){  
				    @Override  
				     public List<Customer> extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				        List<Customer> list=new ArrayList<Customer>();  
				        while(rs.next()){  
				        Customer c=new Customer(); 
				        c.setCustomerAddress(rs.getString(3));
				       c.setCustomerId(rs.getInt(1));
				       c.setCustomerName(rs.getString(2));
				       c.setPaymentMode(rs.getString(4));
				        list.add(c); 
				        System.out.println(c.getCustomerId());
				        System.out.println(c.getCustomerName());
				        System.out.println(c.getCustomerAddress());
				        System.out.println(c.getPaymentMode());
				       
				        
				        }  
				        
				        return list;  
				        }  
				    });  

		}
		
	

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		
			String query = "select * from supplier";
			System.out.println(query);
			 return jdbcTemplate.query(query,new ResultSetExtractor<List<Supplier>>(){  
				    @Override  
				     public List<Supplier> extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				        List<Supplier> list=new ArrayList<Supplier>();  
				        while(rs.next()){  
				        	Supplier c=new Supplier(); 
				        c.setSupplierId(rs.getInt(1));
				       c.setSupplierName(rs.getString(2));
				       c.setSupplierAddress(rs.getString(3));
				       c.setQuantityOrder(rs.getInt(4));
				       c.setOrderId(rs.getInt(5));
				       c.setAmount(rs.getDouble(6));
				        list.add(c); 
				        System.out.println(c.getSupplierId());
				        System.out.println(c.getSupplierName());
				        System.out.println(c.getSupplierAddress());
				        System.out.println(c.getQuantityOrder());
				        System.out.println(c.getOrderId());
				        System.out.println(c.getAmount());
				       
				        
				        }  
				        
				        return list;  
				        }  
				    });  

		
		}
		
		
	

	@Override
	public List<Retailer> getAllRetailer() {
		// TODO Auto-generated method stub
	
	
			String query = "select * from retailer";
			System.out.println(query);
			 return jdbcTemplate.query(query,new ResultSetExtractor<List<Retailer>>(){  
				    @Override  
				     public List<Retailer> extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				        List<Retailer> list=new ArrayList<Retailer>();  
				        while(rs.next()){  

				        	Retailer r = new Retailer();
				        	r.setRetailerId(rs.getInt(1));
				        	r.setRetailerName(rs.getString(2));
				        	r.setRetailerAddres(rs.getString(3));
				 
				        	list.add(r); 
				       
				        }  
				        
				        return list;  
				        }  
				    });  

	}
		
		
	
	}




