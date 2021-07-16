
import java.util.*;
public class Tree {
	Node root;
	
	ArrayList<Node> queue = new ArrayList<>();
	static ArrayList<HuffStuff> huffmanC = new ArrayList<>();
	
	ArrayList<String> huffCodes = new ArrayList<>();
	//counts my huffman code;
	protected int huffmanCodeCount = 0;
	protected int ASCIIBitCount = -1;
	protected String inputString;
	
	public Tree(String userString) {
		
		inputString  = userString;
		//sets an array for the frequency and characters
		int freqArray[] = new int [userString.length()];
		char characterArray[] = new char[userString.length()];
		//adds each character inside the character array
		for(int i = 0; i < userString.length(); i++) {
			characterArray[i] = userString.charAt(i);
		}
		//counts the number of times a character shows up and makes sure is doesnt count duplicates
		for(int i = 0; i < userString.length(); i++) {
			freqArray[i] = 1;
			for(int p = i+1; p < userString.length(); p++) {
				if(characterArray[i] == characterArray[p]) {
					freqArray[i] ++;
					characterArray[p] = ' ';
				}
			}
		}
		//initializes the nodes
        //first array goes through every possible number of times an element could have shown up
        for(int i = 0; i < freqArray.length; i++) {
        	//second array checks if the value is equal to the number we are at and if it isnt a space
            for(int j = 0; j < freqArray.length; j++) {
            	//checks
                if(characterArray[j] != ' ' && freqArray[j] == i) {
                    //add the character and frequency to the queue arrayList in order of how often the show up
                    queue.add(new Node(Character.toString(characterArray[j]), freqArray[j] ));
                }
            }
        }
		ASCIIBitCount = 8 * characterArray.length;
        printQueue();
        for(int i = 0; i < userString.length(); i++) {
        	
        }
        System.out.println("");
    }
	
	//gets and sets the huffman codes
	public void dic(Node current, String code) {
        if (current.getLeft() != null) {
            dic(current.getLeft(), code + "0");
        }
        if (current.getRight() != null) {
            dic(current.getRight(), code + "1");
        }
        if (current.getString().length() == 1) {
            code = current.getString() + code;
            huffCodes.add(code);
        }
    }
	
	//prints the long huffman code
	public void printDic(Node N) {
		int size = inputString.length();
        int numCodes = huffCodes.size();
        String huffString = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < numCodes; j++) {
                if (inputString.charAt(i) == huffCodes.get(j).charAt(0)) {
                    huffString = huffString + huffCodes.get(j).substring(1);
                }
            }
        }
        System.out.println(huffString);
    }

	
	//does the next step of the huffman code tree
	//also the instructions said that we can break ties how ever we want and i break ties differently
	//than the teacher did. This makes my end word different but the values and frequencies are the same.
	public boolean nextStep() {
		//System.out.println("Queue's size is: " + queue.size());
		//these will be used for a new element
		String temporary;
		int temp;
		//checks to see if the arrayList queue has 2 or more elements
		//i.e. is it done
		if(queue.size() >= 2) {
			//makes the string and weight of the new element
			temporary = queue.get(0).getString() + queue.get(1).getString();
			temp = queue.get(0).getFrequency() + queue.get(1).getFrequency();
			huffmanCodeCount +=temp;
			
			//adds the new element in the right spot
			for(int i = 0; i < queue.size(); i++) {
				//checks to see if there is an element bigger than this new one, if so it adds it right before
				//that element
				if(queue.get(i).getFrequency() > temp) {
					queue.add(i,new Node(temporary, temp,queue.get(0),queue.get(1)));
					break;
				}
				//if there isnt an element bigger than the new element it adds it at the end
				else if(i == queue.size()-1) {
					queue.add(new Node(temporary, temp,queue.get(0),queue.get(1)));
					break;
				}
			}
			//removes the two elements used to create the new element
			//have to remove the second element (second one used) first other wise
			//it will remove the wrong thing
			queue.remove(1);
			queue.remove(0);
			return false;
		}
		root = queue.get(0);
		return true;
	}
	
	//prints the queue array List
	public void printQueue() {
		//prints out the queue
		System.out.println("Character\t" + "Count");
		//loops through the queue and prints out each element
		for(int i = 0; i < queue.size(); i++) {
			System.out.println(queue.get(i).getString() + "\t\t" + queue.get(i).getFrequency());
		}
		//I was testing stuff with this next line so i commented it out
		//System.out.println("Huffman Code count is: " + huffmanCodeCount);
	}
	
	public void printFinal()
	{
		dic(root,"");
		//prints each huffman code
		for(int i = 0; i < huffCodes.size(); i++) {
			System.out.println(huffCodes.get(i).charAt(0) + ":\t" + huffCodes.get(i).substring(1));
		}
		System.out.println("The original text is now represented as: ");
		printDic(root);
		//System.out.println(root.getLeft().getString());
		//System.out.println(root.getString());
		System.out.println("Huffman Code count is: " + huffmanCodeCount);
		System.out.println("ASCII Code count is: " + ASCIIBitCount);
		System.out.printf("Compression Rate: %d/%.1ff",huffmanCodeCount,(double)ASCIIBitCount);
	}
}
