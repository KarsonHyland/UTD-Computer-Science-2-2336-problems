import java.util.Scanner;

public class Hyland_Karson_A1_Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create my scanner class named nigga
		Scanner idkWhatToNameThis = new Scanner(System.in);
		//gets the integer from the person
		int distance = 0;
		int time = 0;
		
		//setting my arrays and a variable for later
		int[] years = new int[]{1974, 1975, 1978, 1979, 2013};
		int[] hours = new int[5];
		int[] dis = new int[5];
		double speed = 1.0;
		
		//this takes in the values and fills the arrays
		for(int i = 0; i<5; i++) {
			System.out.println("Enter the distance Diana Nyad swam in " + years[i] + ":");
			distance = idkWhatToNameThis.nextInt();
			dis[i] = distance;
			System.out.println("How many hours did it take Nyad to swim the distance?");
			time = idkWhatToNameThis.nextInt();
			hours[i] = time;
		}
		

		//prints the graph
		for(int i = 0; i < 8; i++) {
			//first and second lines
			if(i == 0 || i == 2) {
				System.out.print("+");
				for(int p = 0; p < 64; p++) {
					System.out.print("-");
				}
				System.out.println("+");
			}
			//titles
			else if(i == 1) {
				System.out.println("| Year   | Distance (miles) | Time (hours) | Speed (miles/hour) |");
			}
			//prints the rest
			else {
				//finds the speed
				int a = dis[i-3];
				int b = hours[i-3];
				speed = (1.0*a/b);
				//figures out how it needs to be printed and prints
				if((dis[i-3]/10) < 10) {
					if(hours[i-3]/10 > 1)
						System.out.printf("%6d   | %d miles %9s %d hours %5s %f"
								+ "\n", years[i-3], dis[i-3], "|", hours[i-3],"|", speed);
					else
						System.out.printf("%6d   | %d miles %9s %d hours %6s %.2f"
								+ "\n", years[i-3], dis[i-3], "|", hours[i-3],"|", speed);
				}
				else {
					System.out.printf("%6d   | %d miles %8s %d hours %5s %f"
							+ "\n", years[i-3], dis[i-3], "|", hours[i-3],"|", speed);
				}
			}
		}
		
	}

}
