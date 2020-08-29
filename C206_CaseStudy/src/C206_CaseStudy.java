import java.util.ArrayList;

public class C206_CaseStudy {
	public static ArrayList<Category> catList = new ArrayList<Category>();
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
	public static ArrayList<Item> itemList=new ArrayList<Item>();
	 
	
	public static void main(String[] args) {
		int option = 0;
		int buyeroption = 0;
		int selleroption = 0;
		int adminoption = 0;
		Category cat1 = new Category ("Books");
		Category cat2 = new Category ("Electronics");
		Category cat3 = new Category ("Stationery");
		Deal d1 = new Deal("123","TestItem", "testSeller@gmail.com", "testBuyer@gmail.com", 12.0, "12/01/12");
		Deal d2 = new Deal("321","TestItem2", "testSeller2@gmail.com", "testBuyer2@gmail.com", 13.0, "12/01/12");
		Item item1= new Item("Lamp", " light weight", 12.50, " 13/07/2020", " 14/08/2020", 0.30);
		Item item2= new Item("Pen", "Zebra 0.5", 1.80, " 13/07/2020", " 14/08/2020", 0.10);
		
		dealList.add(d1);
		dealList.add(d2);
		catList.add(cat1);
		catList.add(cat2);
		catList.add(cat3);
		itemList.add(item1);
		itemList.add(item2);
		while (option != 4) {

			C206_CaseStudy.menu();
			 
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.viewAllCategory(catList);

			} else if (option == 2) {
				//Search item by name or description-Anisa
				C206_CaseStudy.BuyerMenu();
				buyeroption = Helper.readInt("Enter an option : ");
				if (buyeroption == 1) {
					C206_CaseStudy.SearchItemMenu();
						int searchOption=Helper.readInt("Enter option: ");
						if(searchOption==1) {
							String itemName = Helper.readString("Enter Item Name: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemName, ""));
						}else {
							String itemDesc = Helper.readString("Enter Item Description: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemDesc, ""));
						}
					}
				} else if (buyeroption == 2) {
					String result = Helper.readString("Enter category name: ");
					for (int i = 0; i < catList.size(); i++) {
						if (catList.get(i).getName().toString() == result) {
							System.out.println("Results:" + catList.get(i).toString());
						} else {
							System.out.println("No such category found.");
						}
					}
				} else if (buyeroption == 3) {
						//Manage BUYER Deals - David
					
					C206_CaseStudy.BuyerDealMenu();
					
					int buyerChoice = Helper.readInt("Enter an option: ");
					
					if(buyerChoice == 1) { //view Deals
						System.out.println(C206_CaseStudy.viewAllDeal());
						System.out.println(" ");
					}
					
					else if(buyerChoice == 2) { //delete deals
						String dealIDToDelete = Helper.readString("Enter the deal ID you wish to delete: ");
						C206_CaseStudy.delDeal(dealIDToDelete);
					}
					else { //search deals
						
						System.out.println(C206_CaseStudy.viewAllDeal());
						System.out.println(" ");
						C206_CaseStudy.SearchDealMenu();
						
						int searchByChoice = Helper.readInt("Enter how you want to search by: ");
						if(searchByChoice == 1) {
							String itemName = Helper.readString("Enter Item Name: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal(itemName, "", "", 0, ""));
							
						}else if(searchByChoice == 2){
							String buyerEmail = Helper.readString("Enter Buyer Email: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", buyerEmail, "", 0, ""));
							
						}else if(searchByChoice == 3){
							String sellerEmail = Helper.readString("Enter Buyer Email: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", "", sellerEmail, 0, ""));
							
						}else if(searchByChoice == 4){
							double dealPrice = Helper.readDouble("Enter Deal Price: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", "", "", dealPrice, ""));
						}else {
							String closeDate = Helper.readString("Enter Close Date: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", "", "",0 , closeDate));
						}
	
				} 
			}else if (option ==3 ) {
					C206_CaseStudy.SellerMenu();
					selleroption = Helper.readInt("Enter option: ");
					if (selleroption == 1) {
						//Search item by name or description
						C206_CaseStudy.SearchItemMenu();
						int searchOption=Helper.readInt("Enter option: ");
						if(searchOption==1) {
							String itemName = Helper.readString("Enter Item Name: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemName, ""));
							
						}else {
							String itemDesc = Helper.readString("Enter Item Description: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemDesc, ""));
						}
						
					} else if (selleroption == 2) {
						String result = Helper.readString("Enter category name: ");
						for (int i = 0; i < catList.size(); i++) {
							if (catList.get(i).getName().toString() == result) {
								System.out.println("Results:" + catList.get(i).toString());
							} else {
								System.out.println("No such category found.");
							}
						}
					} else if (selleroption == 3) {
							//Manage SELLER Deals - David
						C206_CaseStudy.SellerDealMenu();
						
						int sellerChoice = Helper.readInt("Enter an option: ");
						
						if(sellerChoice == 1){ //add deal
							
							String dealID = Helper.readString("Enter Deal ID: ");
							String itemName = Helper.readString("Enter Item Name: ");
							String buyerEmail = Helper.readString("Enter Buyer Email: ");
							String sellerEmail = Helper.readString("Enter Seller Email: ");
							double dealPrice = Helper.readDouble("Enter Deal Price: ");
							String date = Helper.readString("Enter Close Date: ");
							Deal Deal = new Deal(dealID ,itemName, buyerEmail, sellerEmail, dealPrice, date);
							
							C206_CaseStudy.addDeal(Deal);
						}else if(sellerChoice == 2){ //view deals
							System.out.println(C206_CaseStudy.viewAllDeal());
							System.out.println(" ");
							
						}else if(sellerChoice == 3) { //Delete Deals
							String dealIDToDelete = Helper.readString("Enter the Deal ID You would like to delete: ");
							C206_CaseStudy.delDeal(dealIDToDelete);
						
						}else if(sellerChoice == 4) { //search deals
							System.out.println(C206_CaseStudy.viewAllDeal());
							System.out.println(" ");
							C206_CaseStudy.SearchDealMenu();
							
							int searchByChoice = Helper.readInt("Enter how you want to search by: ");
							if(searchByChoice == 1) {
								String itemName = Helper.readString("Enter Item Name: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal(itemName, "", "", 0, ""));
								
							}else if(searchByChoice == 2){
								String buyerEmail = Helper.readString("Enter Buyer Email: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", buyerEmail, "", 0, ""));
								
							}else if(searchByChoice == 3){
								String sellerEmail = Helper.readString("Enter Buyer Email: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", sellerEmail, 0, ""));
								
							}else if(searchByChoice == 4){
								double dealPrice = Helper.readDouble("Enter Deal Price: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", "", dealPrice, ""));
							}else {
								String closeDate = Helper.readString("Enter Close Date: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", "",0 , closeDate));
							}
						}else { //Update deals
							
							String NewdealID = Helper.readString("Enter which Deal ID you wish to update: ");
							String NewitemName = Helper.readString("Enter your new item name: ");
							String NewbuyerEmail = Helper.readString("Enter your new Buyer email: ");
							String NewSellerEmail = Helper.readString("Enter your new Seller email: ");
							double NewdealPrice = Helper.readDouble("Enter your new deal price: ");
							String NewcloseDate = Helper.readString("Enter your new close date: ");
							
							C206_CaseStudy.updateDeal(NewdealID, NewitemName, NewbuyerEmail, NewSellerEmail, NewdealPrice, NewcloseDate);
							System.out.println("");
							System.out.println(C206_CaseStudy.viewAllDeal());
						}
					}else if(selleroption==4) { //update item-anisa
						
						String name=Helper.readString("Enter item name: ");
						String desc=Helper.readString("Enter item description: ");
						double minPrice=Helper.readDouble("Enter minimum price: ");
						String startDate=Helper.readString("Enter start date: ");
						String endDate=Helper.readString("Enter end date: ");
						double bidIncre=Helper.readDouble("Enter bid increment: ");
						
						C206_CaseStudy.updateItem(name, desc, minPrice, startDate, endDate, bidIncre);
						System.out.println("");
						System.out.println(C206_CaseStudy.viewAllItem());
						System.out.println("");
						
				} else {
					System.out.println("Invalid option!");
					break;
				}

			} else if (option == 4) {
				C206_CaseStudy.AdminMenu();
				adminoption = Helper.readInt("Enter an option > ");
				if (adminoption == 1) {
					System.out.println("Category List");
					for (int i = 0; i < catList.size(); i++) {
						C206_CaseStudy.viewAllCategory(catList);
					}
					int categoryoption = Helper.readInt("Select category number...");
				} else if(adminoption == 2) {
					//manage admin users
				} else if (adminoption == 3) {
					//manage ADMIN deals - David
					 C206_CaseStudy.AdminDealMenu();
					int adminChoice = Helper.readInt("Enter Your choice: ");
					
					if(adminChoice == 1) { //View Deals
						System.out.println(C206_CaseStudy.viewAllDeal());
						System.out.println(" ");
						
					}else if(adminChoice == 2){ //Delete Deal
						String dealIDToDelete = Helper.readString("Enter the Deal ID You would like to delete: ");
						C206_CaseStudy.delDeal(dealIDToDelete);
					}else {//Search Deals
						System.out.println(C206_CaseStudy.viewAllDeal());
						System.out.println(" ");
						C206_CaseStudy.SearchDealMenu();
						
						int searchByChoice = Helper.readInt("Enter how you want to search by: ");
						if(searchByChoice == 1) {
							String itemName = Helper.readString("Enter Item Name: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal(itemName, "", "", 0, ""));
							
						}else if(searchByChoice == 2){
							String buyerEmail = Helper.readString("Enter Buyer Email: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", buyerEmail, "", 0, ""));
							
						}else if(searchByChoice == 3){
							String sellerEmail = Helper.readString("Enter Buyer Email: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", "", sellerEmail, 0, ""));
							
						}else if(searchByChoice == 4){
							double dealPrice = Helper.readDouble("Enter Deal Price: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", "", "", dealPrice, ""));
						}else {
							String closeDate = Helper.readString("Enter Close Date: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchDeal("", "", "",0 , closeDate));
						}
					}
					
				}

			} else if (option == 5){
				System.out.println("Thank you for visiting the shop!");
				break;
			} else {
				System.out.println("Invalid option");
			}
			}
		}
	

	// ----------------------------------- Menu --------------------------------//
	public static void setHeader(String header) {

		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void menu() {
		System.out.println("Campus Online Auction Shop");
		System.out.println("1. View all categories");
		System.out.println("2. Login as buyer");
		System.out.println("3. Login as seller");
		System.out.println("4. Login as admin");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	private static void BuyerMenu() {

		C206_CaseStudy.setHeader("Buyer's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Manage your deals");
	}
	private static void SellerMenu() {

		C206_CaseStudy.setHeader("Seller's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Manage your deals");
		System.out.println("4. Update Item");
	}
	private static void AdminMenu() {

		C206_CaseStudy.setHeader("Admin Home Page");
		System.out.println("1. Manage categories");
		System.out.println("2. Manage users");
		System.out.println("3. Manage deals");
		System.out.println("4. Quit");
	}
	
	 private static void AdminDealMenu() { //David
	        C206_CaseStudy.setHeader("Deal Home Page");
	       
	        System.out.println("1. View Deals");
	        System.out.println("2. Delete Deals");
	        System.out.println("3. Search Deals");
	    
	       
	         
	    }
	   
	    private static void BuyerDealMenu() { //David
	        C206_CaseStudy.setHeader("Deal Home Page");
	        
	        System.out.println("1. View Deals");
	        System.out.println("2. Delete Deals");
	        System.out.println("3. Search Deals");
	        
	       
	        
	    }
	    
	    
	    private static void SellerDealMenu() { //David
	        C206_CaseStudy.setHeader("Deal Home Page");
	        System.out.println("1. Add Deals");
	        System.out.println("2. View Deals");
	        System.out.println("3. Delete Deals");
	        System.out.println("4. Search Deals");
	        System.out.println("5. Update Deals");
	        
	    }
	    
	    private static void SearchDealMenu() { //David
	        C206_CaseStudy.setHeader("Search Deals By:");
	        System.out.println("1. Item Name");
	        System.out.println("2. Buyer Email");
	        System.out.println("3. Seller Email");
	        System.out.println("4. Deal Price");
	        System.out.println("5. Close Date");
	       
	        
	    }
	    
	    private static void SearchItemMenu() { //Anisa
	    	C206_CaseStudy.setHeader("Search Items By: ");
	    	System.out.println("1. Name");
	    	System.out.println("2. Description");
	    }
	    

	// ----------------------------------- Menu --------------------------------//
	
	
	
	
	
	// ----------------------------- Category ---------------------------------- (Julien)//
	public static void addCategory(Category cat) {
		catList.add(cat);
	}
	
	public static String retrieveAllCategory(ArrayList<Category> catList) {
		String output = "";
		for (int i = 0; i < catList.size(); i++) {
			output += String.format("%d. %-10s \n", i+1, catList.get(i).getName().toString());
		}
		return output;
	}
	
	public static void viewAllCategory(ArrayList<Category> catList) {
		Helper.line(120, "-");
		String output = String.format("%-10s \n\n", "Categories");
		output += retrieveAllCategory(catList);
		System.out.println(output);
		Helper.line(120, "-");
	}
	
	public static void deleteCategory(Category c) {
		if (catList.size() !=0) {
			catList.remove(c);
		}
	}
	
	// ----------------------------- Category ---------------------------------- (Julien)//
	
	// ----------------------------- Deals ---------------------------------- (David)//
	
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
	
	
	// ----------------------------- Deals ---------------------------------- (David)//
	// ----------------------------- Anisa ---------------------------------- (Anisa)//
	public static String viewAllItem() {
		String output = "";
		for(int i = 0; i < itemList.size();i++) {
			 output += itemList.get(i).toString();
			 
		}
		
		return output;
	}
	
	public static void addItem(Item item ) { 
		itemList.add(item);
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
	
	public static  String searchItem(String name, String description) {
		 
		String output = "";
		if(itemList.size() != 0) {
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i).getName().equalsIgnoreCase(name)) {
					  output += itemList.get(i).toString();
				}
				else if(itemList.get(i).getDescription().equalsIgnoreCase(description)) {
					  output += itemList.get(i).toString();
					  System.out.println(output);
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
			System.out.println("You have successfully updated your item!");
			}
		}
	}
	//----------------------------- Anisa ---------------------------------- (Anisa)//


