
public class CatalogItem {
	//seting up my variables to be used in ever class and subclass of this class
	private String title;
	private Double price;
	
	//declaring the variables  (constructer)
	public CatalogItem(String word, double cost) {
		title = word;
		price = cost;
	}
	
	//returns the title
	public String getTitle() {
		return title;
	}
	
	//returns the title
	public double getPrice() {
		return price;
	}
}
