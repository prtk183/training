package service;

import org.springframework.jdbc.core.JdbcTemplate;

import repository.GoodsDAO;

public class GoodsServiceImpl implements GoodsService {


	
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
