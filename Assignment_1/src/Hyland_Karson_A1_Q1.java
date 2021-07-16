
public class Hyland_Karson_A1_Q1 {

	public static void main(String[] args) {
		//i am trying a while loop to see if i can get the loop to tell the line numbers and give the right stars or stripes
		//the line counter will tell me which line of the flag i am on starting with the first line
		int lineCounter = 1;
		//the counter will tell me how many characters have been put on that line
		int counter = 0;
		
		//this while loop makes sure i print out only at most 15 lines to make the flag
		while(lineCounter < 16) {
			//this if statement will print out the star lines only if the line needs stars
			if(lineCounter < 10) {
				//this if else statement makes sure to print out the right type of stars for each line
				if(lineCounter%2 == 1) {
					for(int i = 0; i < 6; i++) {
						System.out.print("* ");
						counter+=2;
					}
				}
				else {
					for(int i = 0; i < 5; i++) {
						System.out.print(" *");
						counter+=2;
					}
					System.out.print("  ");
					counter+=2;
				}
			}
			//this prints out the = for the lines
			for(int i = 0; i < (46-counter); i++) {
				System.out.print("=");
			}
			System.out.println("=");
			//resets the counter
			counter = 0;
			//counts the lines
			lineCounter++;
		}

	}

}
