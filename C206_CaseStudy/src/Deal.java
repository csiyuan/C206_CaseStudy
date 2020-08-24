
public class Deal {

	private String dealID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double dealPrice;
	private String closeDate;
	
	public Deal(String dealID, String itemName, String sellerEmail, String buyerEmail, double dealPrice,
			String closeDate) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.dealPrice = dealPrice;
		this.closeDate = closeDate;
	}

	public String getDealID() {
		return dealID;
	}

	public void setDealID(String dealID) {
		this.dealID = dealID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	
	
	public String toString() {
		return "Deal [dealID=" + dealID + ", itemName=" + itemName + ", sellerEmail=" + sellerEmail + ", buyerEmail="
				+ buyerEmail + ", dealPrice=" + dealPrice + ", closeDate=" + closeDate + "]";
	} 
	
	
	
	
	

}
