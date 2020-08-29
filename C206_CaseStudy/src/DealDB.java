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
				System.out.println("You Have Successfully Deleted Deal: " + dealList.get(i).getDealID());
				System.out.println("");
			}else {
				System.out.println("You have entered an invalid deal id");
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
	
	public static void  updateDeal(String dealID, String itemName, String buyerEmail, String sellerEmail, double dealPrice, String closeDate) {
		for(int i = 0; i < dealList.size(); i++) {
			if(dealList.get(i).getDealID().equals(dealID)) {
				dealList.get(i).setItemName(itemName);
				dealList.get(i).setBuyerEmail(buyerEmail);
				dealList.get(i).setSellerEmail(sellerEmail);
				dealList.get(i).setDealPrice(dealPrice);
				dealList.get(i).setCloseDate(closeDate);
				System.out.println("");
				System.out.println("You have successfully updated your deal!");
			}
		}
	}
	
	public static String feedback(String fdback) {
		return fdback;
	}
		
	
 
}
