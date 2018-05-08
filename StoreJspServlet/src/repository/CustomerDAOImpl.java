package repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository()
@Qualifier("customerDAO")
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

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("jdbcTemplate::CustomerDAOImpl:"+jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addCustomer(Customer e) {

		String query = "insert into customer values(" + e.getCustomerId() +","+ "'"+ e.getCustomerName()+"'" + ","
			+"'"+ e.getCustomerAddress()+"'" + "," +"'"+ e.getPaymentMode()+"'" + ")";
		System.out.println(query);
		return jdbcTemplate.update(query);

	}

	public int updateCustomer(int customerID, String name) {

		String query = "update customer set customerName=" + "'" + name + "'" + " where customerId=" + customerID;
		// String query = "update customer set customerName="+name+" where customerId="+
		// customerID;

		System.out.println(query);
		return jdbcTemplate.update(query);

	}

	public int removeCustomer(int id) {
		String query = "delete from customer where customerId="+id;
		System.out.println(query);
		return jdbcTemplate.update(query);
	}
}
