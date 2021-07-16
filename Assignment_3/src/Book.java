
class Book extends CatalogItem {
	//making the variables for this class and its subclass
	private String author;
	private int ISBN;
	
	//declaring the variables  (constructer)
	public Book(String title, double price, String author2, int iSBN2) {
		super(title, price);
		author = author2;
		ISBN = iSBN2;
	}

	//returns the ISBN
	public int getISBN() {
		return ISBN;
	}
	
	//return the author
	public String getAuthor() {
		return author;
	}
	
	//returns the info of the book
	public String toString() {
		String info = "Title: " + getTitle() + " | ";
		info += "Author: " + author + " | ";
		info += "Price: " + getPrice() + " | ";
		info += "ISBN: " + ISBN;
		return info;
	}
	
}
