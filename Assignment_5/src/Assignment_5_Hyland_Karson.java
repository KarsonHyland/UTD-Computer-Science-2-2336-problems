import java.util.*;
public class Assignment_5_Hyland_Karson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//first i have to get the string from the user
		String userInput;
		Scanner stringScan = new Scanner(System.in);
		
		System.out.println("Please enter a string to be used: ");
		userInput = stringScan.nextLine();
		
		while(true) {
			if(userInput.isEmpty()) {
				System.out.println("Please enter non empty a string to be used: ");
				userInput = stringScan.nextLine();
			}
			else
				break;
		}
		
		Tree usersTree = new Tree(userInput);
		while(true) {
			if(usersTree.nextStep() == true) {
				break;
			}
			else {
				System.out.println("Are you ready for the next step (they said to move on no matter what you say): ");
				stringScan.nextLine();
				usersTree.printQueue();
			}
		}
		
		usersTree.printFinal();

	}

}
