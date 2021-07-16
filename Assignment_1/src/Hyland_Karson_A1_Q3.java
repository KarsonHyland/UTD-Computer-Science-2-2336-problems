import java.util.*;

public class Hyland_Karson_A1_Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create my scanner class named nigga
				Scanner idkWhatToNameThis = new Scanner(System.in);
				//gets the integer from the person
				int num = idkWhatToNameThis.nextInt();
				int num2 = num;
				int num3;
				int total = 0;
				String word = "";
				//prints the numbers in pyrimid form
				for(int i = 1; i < num; i++) {
					word += "1";
					num3 = Integer.parseInt(word);
					num2 = num2* num3;
					if(i != num - 1)
						System.out.print(num2 +" + ");
					else
						System.out.print(num2 + " = ");
					total += num2;
					num2 = num;
				}
				System.out.println(total);
	}

}
