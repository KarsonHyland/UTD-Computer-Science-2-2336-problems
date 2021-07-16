import java.util.*;
public class Hyland_Karson_A1_Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create my scanner class named nigga
		Scanner idkWhatToNameThis = new Scanner(System.in);
		//gets the integer from the person
		int num = idkWhatToNameThis.nextInt();
		
		//prints the pyramid
		for(int i = 1; i <= num; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
