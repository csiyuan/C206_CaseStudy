import java.util.ArrayList;

public class DealDB {

	public static ArrayList<Deal> dealList = new ArrayList<Deal>();

	public static void addDeal(Deal d) {

		dealList.add(d);
	}
	
	public static String viewAllDeal() {
		String output = "";
		for(int i = 0; i < dealList.size();i++) {
			 output += dealList.get(i).toString();
			 
		}
		
		return output;
	}
	
	public static void delDeal(Deal d) {
		if(dealList.size() != 0) {
			dealList.remove(d);
		}
	}

	 
}
