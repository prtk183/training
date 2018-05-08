
package model;


public class Retailer {

	private String retailerName;
	private String retailerAddres;
	int retailerId;
	public int getRetailerId() {
		return retailerId;
	}


	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}


	public Retailer(String retailerName, String retailerAddres) {
		this.retailerName = retailerName;
		this.retailerAddres = retailerAddres;
	}

	
	public Retailer() {
		// TODO Auto-generated constructor stub
	}


	public String getRetailerName() {
		return retailerName;
	}


	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	
	public String getRetailerAddres() {
		return retailerAddres;
	}

	
	public void setRetailerAddres(String retailerAddres) {
		this.retailerAddres = retailerAddres;
	}


}
