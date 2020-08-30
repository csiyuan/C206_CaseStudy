
public class Item {
	
	private String name;
	private String description;
	private double minPrice;
	private String startDate;
	private String endDate;
	private double bidIncrement;
	
	

	public Item(String name, String description, double minPrice, String startDate, String endDate,
			double bidIncrement) {
		this.name = name;
		this.description = description;
		this.minPrice = minPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidIncrement = bidIncrement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

	@Override
	public String toString() {
		 return "Item: " + name + "\nDescription: " + description   
					+ "\nMinimum Price: $" + minPrice + "\nStart Date: "
					+ startDate + "\nEnd Date: " + endDate + "\nBid Increment: $" + bidIncrement +"\n\n" ;
	}
	

}
