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
	
	public static String viewAllItem() {
		String output = "";
		for(int i = 0; i < itemList.size();i++) {
			 output += itemList.get(i).toString();
			 
		}
		
		return output;
	}
		
	public static void delItem( String item) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(item) ) {
				itemList.remove(i);
				System.out.println("You Have Successfully Deleted Item: " + itemList.get(i).getName());
				System.out.println("");
			}else {
				System.out.println("Delete failed");
			}
		}
	}
	
	public static void showItemMenu() {

		System.out.println("1. View Items");
		System.out.println("2. Add Item");
		System.out.println("3. Delete Item");
		System.out.println("4. Search Item");
		System.out.println("5. Update Item");
		System.out.println("6. Quit");
	}
	
	public static  String searchItem(String name, String description) {
		 
		String output = "";
		if(itemList.size() != 0) {
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i).getName().equalsIgnoreCase(name)) {
					  output += itemList.get(i).toString();
				}
				else if(itemList.get(i).getDescription().contains(description)) {
					  output += itemList.get(i).toString();
				}
				else {
					output += "You have entered an invalid search";
				}
			}
		}
		
		return output;
	}
	
	public static void  updateItem(String itemName, String desc, double minPrice, String startDate, String endDate, double bidIncrement) {
		for(int i = 0; i < itemList.size(); i++) {
			itemList.get(i).setName(itemName);
			itemList.get(i).setDescription(desc);
			itemList.get(i).setMinPrice(minPrice);
			itemList.get(i).setStartDate(startDate);
			itemList.get(i).setEndDate(endDate);
			itemList.get(i).setBidIncrement(bidIncrement);
			System.out.println("");
			}
		System.out.println("You have successfully updated your item!");
		}
	}
