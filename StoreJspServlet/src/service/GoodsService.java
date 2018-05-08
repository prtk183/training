package service;

public interface GoodsService {

	public int addGoods( int goodsId,String goodsName,int goodsQuantity,double goodsPrice);
	public int removeGoods(int goodsId);
	public int updateGoods(int goodsId, String Updatedata);
		
}
