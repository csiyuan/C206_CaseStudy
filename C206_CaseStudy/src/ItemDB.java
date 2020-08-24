import java.util.ArrayList;

public class ItemDB {
	
	public static ArrayList<Item> itemList=new ArrayList<Item>();
	
	public static void addItem(Item item) {
		
		itemList.add(item);
	}
	
	public static String retrieveAllItem(ArrayList<Item>itemList) {
		String output="";
		
		for(int i=0; i<itemList.size(); i++) {
			
			output += String.format("%-84s \n", itemList.get(i).toString());
		}
		return output;
		
	}
	
	public static void viewAllItem() {
		String output=String.format("%-10s %-30s $-10s %-10 %-20s %-10s %10s\n", "Item", "Description", "Price", "Start Date", "End Date", "Increment");
		output += retrieveAllItem(itemList);
		System.out.println(output);
		
	}
	
	public static void delItem(Item item) {
		if(itemList.size() !=0) {
			itemList.remove(item);
		}
		
	}
}
