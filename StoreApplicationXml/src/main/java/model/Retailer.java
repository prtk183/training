
package model;


public class Retailer {

	private String retailerName;
	private String retailerAddres;
	
	public Retailer(String retailerName, String retailerAddres) {
		this.retailerName = retailerName;
		this.retailerAddres = retailerAddres;
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
