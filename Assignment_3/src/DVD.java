
class DVD extends CatalogItem {
	//declares the variables
	private String director;
	private int yearMade;
	private int dvdCode;
	
	//declaring the variables  (constructer)
	public DVD(int iSBN, String title, double price, String author, int yearMade2) {
		super(title, price);
		director = author;
		yearMade = yearMade2;
		dvdCode = iSBN;
	}

	//returns the director
	public String getDirector() {
		return director;
	}
	
	//returns year made
	public int getYear() {
		return yearMade;
	}
	
	//returns the dvd code
	public int getDvdCode() {
		return dvdCode;
	}
	
	//returns the info of the dvd
	public String toString() {
		String info = "Title: " + getTitle() + " | ";
		info += "Director: " + director + " | ";
		info += "Price: " + getPrice() + " | ";
		info += "Year: " + yearMade + " | ";
		info += "DvdCode: " + dvdCode;
		return info;
	}
}
