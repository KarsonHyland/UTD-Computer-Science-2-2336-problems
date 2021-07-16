import java.util.*;
import java.io.*;

public class Assignment_2_Hyland_Karson {
	
	//This displays the menu
	public static void displayMenu() {
		System.out.println("**Welcome to the Comet Books and DVDs Store**\n");
		System.out.println("Choose from the following options:");
		// this takes advantages of printf features to display the main menu
		System.out.printf("1 - %s\n2 - %s\n3 - %s\n4 - %s\n5 - %s\n6 - %s\n7 - %s\n9 - %s\n",
				"Browse books inventory (price low to high)","Browse DVDs inventory (price low to high)",
				"add a book to the cart","add a DVD to the cart","View cart","Checkout","Cancel Order","Exit store");
	}
	
	//this functions is able to display the inventory of the books and dvds
	public static void displayInventory(String type, int[] invNum, String[] name, double[] price) {
		//these next two lines tell you the type of inventory it is displaying and set up the table
		System.out.print("Inventory Number    ");
		System.out.printf("%-22.5s prices\n", type);
		System.out.println("-------------------------------------------------");
		//this for loop loops through the array that was passed and prints out the inv number, name, and prices of the books in order
		for(int i = 0; i < 5; i++) {
			//this is used to help display the prices correctly
			String prices = "$" + String.format("%.2f", price[i]);
			//this displays every book and its price that we have in the inventory
			System.out.printf("%-19d %-21.13s %7s\n", invNum[i], name[i], prices);
		}
	}
	
	//this method is used to take the inventory number the user wants to add to the cart
	public static int getInventoryNumber() {
		//sets up the scanner
		Scanner scan = new Scanner(System.in);
		//the while loop and if statements make sure the user inputs a number that is assigned to an item in our inventory
		while(true) {
			int userInput = scan.nextInt();
			if(userInput == -1)
				break;
			else if(userInput < 1 || userInput > 5)
				break;
			else
				//returns the users input if it is within bounds else returns -1
				return userInput;
		}
		return -1;
	}
	
	//gets the total of the items inside the ccart
	public static double getTotal(double[] nums) {
		double total = 0;
		//goes through the array passed in and adds all values to the total
		for (double element : nums) {
			total += element;
		}
		total = total * 1.0825;
		//returns the total
		return total;
	}

	public static void main(String[] args) {
		//sets up my scanner
		Scanner userInput = new Scanner(System.in);
		//option is the option the user chooses
		int option;
		//breaker keeps the while loop going until it is made false
		boolean breaker = true;
		//makes the new dvds class
		DVDS myDVDS = new DVDS();
		//makes the new books class
		Books myBooks = new Books();
		//makes an array to hold the names of all the items the user wants
		String[] usersCart = new String[10];
		//makes an array to hold the prices of all the items the user wants
		double cartPrices[] = new double[10];
		//counts where we are in the cart
		int cartAmount = 0;
		//the while loops keeps the program running until they say they are ready to quit
		while(breaker) {
			//displays menu
			displayMenu();
			//gets the option the user wants to do
			option = userInput.nextInt();
			//does the correct option
			switch(option) {
			case 1:
				//displays the inventory of the books for the user
				displayInventory("Books", myBooks.invNum,myBooks.name,myBooks.price);
				break;
			
			case 2:
				//displays the inventory of the DVDS for the user
				displayInventory("DVDS", myDVDS.invNum,myDVDS.name,myDVDS.price);
				break;
			
			case 3:
				//adds the books of the number the user chose
				int num = getInventoryNumber();
				//tests if they said they wanted to go back (if -1 is returned) otherwise it adds it to the cart
				if(num != -1) {
					usersCart[cartAmount] = myBooks.name[num-1];
					cartPrices[cartAmount] = myBooks.price[num-1];
					cartAmount++;
				}
				break;
			
			case 4:
				//adds the DVDS of the number the user chose
				int num1 = getInventoryNumber();
				//tests if they said they wanted to go back (if -1 is returned) otherwise it adds it to the cart
				if(num1 != -1) {
					usersCart[cartAmount] = myDVDS.name[num1-1];
					cartPrices[cartAmount] = myDVDS.price[num1-1];
					cartAmount++;
				}
				break;
				
			case 5:
				//displays what is in the users cart if it has anything otherwise says the cart is empty
				if(usersCart[0] != null) {
					//prints the first two lines of the display
					System.out.println("Items             Prices\n"+
									   "------------------------");
					//goes through and displays everything inside the users cart
					for(int i = 0; i < usersCart.length; i++) {
						//makes sure it is only printing the stuff that has been added to the cart
						if(cartPrices[i] != 0)
							//uses printf to format correctly
							System.out.printf("%-15.14s  %7s\n", usersCart[i],"$"+ String.format("%.2f",cartPrices[i]));
					}
					System.out.println("------------------------");
					//prints the total
					System.out.printf("Total + tax      %7s\n","$" + String.format("%.2f",getTotal(cartPrices)));
				}
				else {
					System.out.println("your cart is empty");
				}
				break;
				
			case 6:
				//prints the total
				System.out.printf("total: $%.2f\n", getTotal(cartPrices));
				//the next 3 lines clear the cart
				Arrays.fill(cartPrices, 0);
				Arrays.fill(usersCart, null);
				cartAmount = 0;
				break;
				
			case 7:
				//the next 3 lines clear the cart
				Arrays.fill(cartPrices, 0);
				Arrays.fill(usersCart, null);
				cartAmount = 0;
				break;
				
			case 9:
				//closes the program by breaking out of the while loop
				breaker = false;
				break;
				
			default:
				//if they dont enter one of the correct options tells them to enter another option
				System.out.println("This option is not acceptable");
				break;
			}
		}
	}

}
