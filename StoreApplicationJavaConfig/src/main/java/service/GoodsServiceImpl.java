package service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import repository.GoodsDAO;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
	
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

	@Autowired
	public GoodsDAO goodsDAO;


	@Override
	public int addGoods(int goodsId, String goodsName, int goodsQuantity,
			double goodsPrice) {
	
		int addData =  goodsDAO.addGoods(goodsId, goodsName, goodsQuantity,
				goodsPrice);
		return addData;
	}

	@Override
	public int removeGoods(int goodsId) {
		//GoodsDAO goodsDAO = null;
		int remmoveData = goodsDAO.removeGoods(goodsId);
		return remmoveData;
	}

	@Override
	public int updateGoods(int goodsId, String updatedata) {
		//GoodsDAO goodsDAO = null;
		int updateData = goodsDAO.updateGoods(goodsId, updatedata);
		return updateData;
	}

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

}
