import java.util.Scanner;

/*
 * I want to make a program that takes an array and and moves to the right and left until it reaches the end
 * the number  it moves is determined by the number at that instance in the array
 * 
 * I also want to make a function that tests to see if it gets stuck in a loop
 */
public class Hyland_Karson_A4_Q1 {
	
	//This function sees if the array fits the puzzle
	 static boolean Solvable(int start, int[] squares) {
		 //set the right shift
		 int rightShift = start + squares[start];
		 //set the left shift
		 int leftShift = start - squares[start];
		 //check to see if you reached the end correctly first
		 if(squares[start]==0)
			 //if so return true saying it is solvable (this cause the recursion to shoot back making everything return true until
			 //the first time it was called returns true, making the program work
			 return true;
		 //checks for an infinite loop
		 if(rightShift < squares.length && squares[start] == squares[rightShift]) {
			 if(leftShift > 0 && squares[start] == squares[leftShift])
				 return false;
			 else
				 return false;
		 }
		 //check to see if the right shift is available and then check with the right shift as the new start
		 if(rightShift < squares.length && Solvable(rightShift,squares))
			 return true;
		//check to see if the left shift is available and then check with the left shift as the new start
		 if(leftShift > 0 && Solvable(leftShift,squares))
			 return true;
		 //if all those failed return false
		 return false;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//gets the array size
		System.out.println("Enter the Array size(number of values inside of the array i.e. [3,1,2,3,0] would be size 5): ");
		int size = scan.nextInt();
		//sets the size of the array
		int arry[] = new int[size];
		//gets all the values
		System.out.println("Enter the values for the array: ");
		for(int i = 0; i < size; i++) {
			arry[i] = scan.nextInt();
		}
		//sees if it is solvable
		boolean works = Solvable(0,arry);
		//tells you if it works
		if(works)
			System.out.println("solved");
		else
			System.out.println("unsolvable");
	}

}
