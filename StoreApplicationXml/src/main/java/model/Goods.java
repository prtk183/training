package model;

public class Goods {

	private int goodsId;
	private String goodsName;
	private int goodsQuantity;
	private double goodsPrice;


	public Goods(int goodsId, String goodsName, int goodsQuantity,
			double goodsPrice) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsQuantity = goodsQuantity;
		this.goodsPrice = goodsPrice;
	}

	public Goods() {
		// TODO Auto-generated constructor stub
	}

	
	public int getGoodsId() {
		return goodsId;
	}

	
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	
	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	
	public int getGoodsQuantity() {
		return goodsQuantity;
	}

	
	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

	
	public double getGoodsPrice() {
		return goodsPrice;
	}

	
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}
