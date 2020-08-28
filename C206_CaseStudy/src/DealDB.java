import java.util.ArrayList;

public class DealDB {

	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
	
	
	public static void addDeal(Deal d ) {
		 
		 
		dealList.add(d);
	}
	
	public static String viewAllDeal() {
		String output = "";
		for(int i = 0; i < dealList.size();i++) {
			 output += dealList.get(i).toString();
			 
		}
		
		return output;
	}
	
	public static void delDeal( String dealID) {
		for(int i = 0; i < dealList.size(); i++) {
			if(dealList.get(i).getDealID().equals(dealID) ) {
				dealList.remove(i);
			}
		}
	}
	
	public static  String searchDeal(String itemName, String buyerEmail, String sellerEmail, double dealPrice, String closeDate ) {
		 
	
		String output = "";
		if(dealList.size() != 0) {
			for(int i = 0; i < dealList.size(); i++) {
				if(dealList.get(i).getItemName().equals(itemName)) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getBuyerEmail().equals(buyerEmail)) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getSellerEmail().equals(sellerEmail)) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getDealPrice()==dealPrice) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getCloseDate().equals(closeDate)) {
					  output += dealList.get(i).toString();
				}
				else {
					output += "You have entered an invalid search";
				}
			}
		}
		
		return output;
	}
	
	public static void  updateDeal(Deal d, String itemName, String buyerEmail, String sellerEmail, double dealPrice, String closeDate) {
		d.setItemName(itemName);
		d.setBuyerEmail(buyerEmail);
		d.setSellerEmail(sellerEmail);
		d.setDealPrice(dealPrice);
		d.setCloseDate(closeDate);
	}
	
	public static String feedback(String fdback) {
		return fdback;
	}
		
	
 
}
