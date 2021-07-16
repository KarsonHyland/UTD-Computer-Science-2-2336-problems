/*Making a store catalog from the owners perspective
 * requirements:
 *
 * make a catalog Item class:
 * -The catalog class must have a name of every catalog item (string) and a price(double)
 * -There must be a book and DVD class that extends off the catalog item class
 * -The book class must have an author (string) and an ISBN number (Int) as well as an audioBook class that extends off of it
 *      and has a running time variable(double).
 * -The DVD class must have a director (string), Year made (int), and a DVD code (int)
 * 
 * A toString method that  prints all the info of an item
 * 
 * ArrayList for Books and DVDS
 */

/*Hello mr/mrs/ms grader in assignment 1 for ranran feng 2336 you messed up the grading of my assignment and gave me a 75/100
 * I tried emailing you and the email you gave on elearning and emailed us with is invalid, so i tried emailing ran ran feng too
 * she brushed me off and has not been to a single one of her office hours. I would like you to fix my grade for assignment 1 as i have
 * been trying to get you or ranran feng to fix it for the past 2 weeks (as of 10/04/2020).
 * My netID is KJH19000 and name is Karson James Hyland and email is KJH190000@utdallas.edu
 * please help i want my grade
 */

import java.util.*;

public class Hyland_Karson_Assignment_3 {
	
	//This displays the menu
		public static void displayMenu() {
			System.out.println("**Welcome to the Comet Books and DVDs Store**");
			System.out.println("Choose from the following options:");
			// this takes advantages of printf features to display the main menu
			System.out.printf("1 - %s\n2 - %s\n3 - %s\n4 - %s\n5 - %s\n6 - %s\n9 - %s\n",
					"Add Book","Add AudioBook","Add DVD","Remove Book","Remove DVD","Display Catalog","Exit Store");
		}

	public static void main(String[] args) {
		
		//i had to make 3 scanners for each variable type as i didnt want to keeep opening and closing my scanners
		Scanner scanInt  = new Scanner(System.in);
		Scanner scanString  = new Scanner(System.in);
		Scanner scanDouble  = new Scanner(System.in);
		
		//keeps the while loop running
		boolean test = true;
		
		//making the input variables to go into my classes
		String title;
		//author/director
		String author;
		//ISBN/DvdCode
		int ISBN;
		int yearMade;
		double price;
		double runTime;
		//boolean to help me figure out if the item is in the array lists
		boolean inStock = false;
		
		//book/audioBook list
		ArrayList<Book> BookList = new ArrayList<Book>();
		ArrayList<DVD> DVDList = new ArrayList<DVD>();
		
		//the whole program
		while(test){
			//displays the menu
			displayMenu();
			//asks for the option
			int option = scanInt.nextInt();
			//Chooses the option
			switch(option) {
				case 1:
					//adds the book
					//gets the ISBN
					System.out.println("What is the ISBN of the book you would like to add: ");
					ISBN = scanInt.nextInt();
					//goes through every item in the list
						for(int i = 0; i < BookList.size(); i++) {
							//checks if each item is in the catalog, if it is say so and make inStock true
							if(ISBN == BookList.get(i).getISBN()) {
								System.out.println("The book is already in the catalog.");
								inStock = true;
								break;
							}
							//else make inStock false
							else {
								inStock = false;
							}
						}
						//if inStock is false get the rest of the info
						if(!inStock){
							System.out.println("What is the title of the book you would like to add: ");
							title = scanString.nextLine();
							System.out.println("What is the price of the book you would like to add: ");
							price = scanDouble.nextDouble();
							System.out.println("Who is the author of the book you would like to add: ");
							author = scanString.nextLine();
							//checks if they dumb and put in bad info
							if(ISBN <= 0 || title == "" || title == " " || price <= 0 || author == "" || author == " ")
								System.out.println("Invalid input (going back to main menu)");
							else {
								//else make and add the class
								Book book1 = new Book(title,price,author,ISBN);
							    BookList.add(book1);
							}
						}
					break;
				case 2:
					//same as 1
					System.out.println("What is the ISBN of the audioBook you would like to add: ");
					ISBN = scanInt.nextInt();
						for(int i = 0; i < BookList.size(); i++) {
							if(ISBN == BookList.get(i).getISBN()) {
								System.out.println("The book is already in the catalog.");
								inStock = true;
								break;
							}
							else {
								inStock = false;
							}
						}
					if(inStock == false) {
						System.out.println("What is the title of the audioBook you would like to add: ");
						title = scanString.nextLine();
						System.out.println("What is the price of the audioBook you would like to add: ");
						price = scanDouble.nextDouble();
						System.out.println("Who is the author of the audioBook you would like to add: ");
						author = scanString.nextLine();
						System.out.println("What is the run time of the audioBook you would like to add: ");
						runTime = scanDouble.nextDouble();
						if(ISBN <= 0 || title == "" || title == " " || price <= 0 || author == "" || author == " " || runTime <= 0)
							System.out.println("Invalid input (going back to main menu)");
						else {
							audioBook audioBook1 = new audioBook(title, price, author, ISBN, runTime);
						    BookList.add(audioBook1);
						}
					}
					break;
				case 3:
					//same as 1
					System.out.println("What is the DvdCode of the DVD you would like to add: ");
					ISBN = scanInt.nextInt();
						for(int i = 0; i < BookList.size(); i++) {
							if(ISBN == BookList.get(i).getISBN()) {
								System.out.println("The book is already in the catalog.");
								inStock = true;
								break;
							}
							else {
								inStock = false;
							}
						}
					if(inStock == false) {
						System.out.println("What is the title of the DVD you would like to add: ");
						title = scanString.nextLine();
						System.out.println("What is the price of the DVD you would like to add: ");
						price = scanDouble.nextDouble();
						System.out.println("Who is the director of the DVD you would like to add: ");
						author = scanString.nextLine();
						System.out.println("What is the year the DVD you would like to add was made: ");
						yearMade = scanInt.nextInt();
						if(ISBN <= 0 || title == "" || title == " " || price <= 0 || author == "" || author == " " || yearMade <= 0)
							System.out.println("Invalid input (going back to main menu)");
						else {
							DVD DVD11 = new DVD(ISBN, title, price, author, yearMade);
						    DVDList.add(DVD11);
						}
					}
					break;
				case 4:
					//ask for the ISBN
					System.out.println("What is the ISBN of the book/AudioBook you want to remove:");
					int removal = scanInt.nextInt();
					//checks through every item in the list then removes it if the ISBN is the same
					for(int i = 0; i < BookList.size(); i++) {
						if( BookList.get(i).getISBN() == removal)
							BookList.remove(i);
					}
					break;
				case 5:
					//same as 4
					System.out.println("What is the DvdCode of the DVD you want to remove:");
					int removal1 = scanInt.nextInt();
					for(int i = 0; i < BookList.size(); i++) {
						if( DVDList.get(i).getDvdCode() == removal1)
							BookList.remove(i);
					}
					break;
				case 6:
					//prints all the info
					for(int i = 0; i < BookList.size(); i++) {
						System.out.println(BookList.get(i).toString());
					}
					System.out.println("----------------------------------------------"
							+ "----------------------------------------------------------------------------------------");
					for(int i = 0; i < DVDList.size(); i++) {
						System.out.println(DVDList.get(i).toString());
					}
					break;
				case 9:
					//leaves the program
					test = false;
					break;
				default:
					//tells them they inputed something wrong
					System.out.println("That's not one of the options");
					break;
			}
		}
		

	}

}
