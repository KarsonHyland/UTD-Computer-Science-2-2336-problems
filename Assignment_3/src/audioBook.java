
class audioBook extends Book{

	private double runTime;
	
	//declaring the variables  (constructer)
	public audioBook(String title, double price, String author2, int iSBN2, double runTime2) {
		super(title, price, author2, iSBN2);
		runTime = runTime2;
	}
	
	//returns the run time
	public double getRunTime() {
		return runTime;
	}
	
	//returns the info of the audio book
	public String toString() {
		String info = "Title: " + getTitle() + " | ";
		info += "Author: " + getAuthor() + " | ";
		info += "Price: " + getPrice() * 0.9 + " | ";
		info += "ISBN: " + getISBN();
		info += " | RunningTime: " + runTime;
		return info;
	}
	
}
