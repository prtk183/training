package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class GoodsDAOImpl implements GoodsDAO {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public int addGoods(int goodsId, String goodsName, int goodsQuantity,
			double goodsPrice) 
	{
		String query = "insert into goods values(" +goodsId+","+ "'"+goodsName +"'"+","+goodsQuantity+","+ goodsPrice +")";
		System.out.println(query);
		
		return jdbcTemplate.update(query);
	}
	
	

	@Override
	public int updateGoods(int goodsId, String goodsName) {
		String query = "update goods set goodsName=" + "'" + goodsName + "'" + " where goodsId=" + goodsId;
		// String query = "update customer set customerName="+name+" where customerId="+
		// customerID;

		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	@Override
	public int removeGoods(int goodsId) {
		
		String query = "delete from goods where goodsId="+goodsId;
		System.out.println(query);
		return jdbcTemplate.update(query);
	}


	

}
