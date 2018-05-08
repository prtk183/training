package controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import repository.CustomerDAO;
import repository.CustomerDAOImpl;
import repository.GoodsDAO;
import repository.GoodsDAOImpl;
import repository.RetailerDAO;
import repository.RetailerDAOImpl;
import repository.SupplierDAO;
import repository.SupplierDAOImpl;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.GoodsService;
import service.GoodsServiceImpl;
import service.RetailerService;
import service.RetailerServiceImpl;
import service.SupplierService;
import service.SupplierServiceImpl;

@Configuration
@ComponentScan(basePackages= {"controller","service", "model", "repository"})
@PropertySource("database.properties")
public class AppConfig {

	AppConfig()
	{
		
	}
	
	@Autowired
	Environment environment;
	
	public static final String url="url";
	public static final String driver="driver";
	public static final String password="password";
	public static final String user="user";
	
	@Bean
	DataSource dataSource() {
		final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(url));
		driverManagerDataSource.setUsername(environment.getProperty(user));
		driverManagerDataSource.setPassword(environment.getProperty(password));
		driverManagerDataSource.setDriverClassName(environment.getProperty(driver));
		return driverManagerDataSource;
	}

	
	@Bean
	JdbcTemplate jdbcTempalte(DataSource dataSource)
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	return jdbcTemplate;
	}
	
	
	/*
	 * beans for services
	 */
	@Bean
	public CustomerService customerService()
	{
		return new CustomerServiceImpl();
	}
	
	@Bean
	public GoodsService goodsService()
	{
		return new GoodsServiceImpl();
	}
	
	@Bean
	public RetailerService retailerService()
	{
		return new RetailerServiceImpl();
	}
	
	@Bean
	public SupplierService supplierService()
	{
		return new SupplierServiceImpl();
	}
	
	/*
	 * beans for DAO
	 * 
	 */
	
	@Bean
	public CustomerDAO customerDAO()
	{
		return new CustomerDAOImpl();
	}
	
	@Bean
	public GoodsDAO goodsDAO()
	{
		return new GoodsDAOImpl();
	}
	
	@Bean
	public RetailerDAO retailerDAO()
	{
		return new RetailerDAOImpl();
	}
	
	@Bean
	public SupplierDAO supplierDAO()
	{
		return new SupplierDAOImpl();
	}
	
	
}
