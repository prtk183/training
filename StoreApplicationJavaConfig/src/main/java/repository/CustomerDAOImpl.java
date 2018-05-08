package repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	private DataSource dataSource;
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("jdbcTemplate::CustomerDAOImpl:"+jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addCustomer(Customer e){
		//System.out.println("in dao");
		String query="";
		int flag=3;
		try {
			
		
			 query = "insert into customer values(" + e.getCustomerId() +","+ "'"+ e.getCustomerName()+"'" + ","
			+"'"+ e.getCustomerAddress()+"'" + "," +"'"+ e.getPaymentMode()+"'" + ")";
			System.out.println(query);
			flag=  jdbcTemplate.update(query);
			//System.out.println("in dao try"+flag);
		}
		catch(Exception error)
		{
			flag=0;
		}
		finally
		{
			//System.out.println("in last "+flag);
			return flag;

		}
	}
	
	public int updateCustomer(int customerID, String name) {

		int flag=0;
		try
		{
		String query = "update customer set customerName=" + "'" + name + "'" + " where customerId=" + customerID;
		// String query = "update customer set customerName="+name+" where customerId="+
		// customerID;

		System.out.println(query);
		flag= jdbcTemplate.update(query);
		}
		catch(Exception error)
		{
			flag=0;
		}
		finally
		{
		
			return flag;
		}
		
		

	}

	public int removeCustomer(int id) {
		int flag=0;
		try
		{
		String query = "delete from customer where customerId="+id;
		System.out.println(query);
	
		flag=jdbcTemplate.update(query);
		}
		catch(Exception error)
		{
			flag=0;
		}
		finally
		{
		
			return flag;
		}
	}
}
