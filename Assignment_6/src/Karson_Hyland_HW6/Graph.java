package Karson_Hyland_HW6;

import java.util.*;
import Karson_Hyland_HW6.WeightedGraph.Edge;
import Karson_Hyland_HW6.WeightedGraph.Vertex;

public class Graph {
	int numVertices;
    ArrayList<Edge> edgeAdjacencylist = new ArrayList<>();
    ArrayList<Vertex> vertexList = new ArrayList<>();
    int[][] adjacencyMatrix;

    Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i < numVertices ; i++) {
            for(int j = 0; j < numVertices; j++) {
            	adjacencyMatrix[i][j] = 0;
            }
        }
    }
    
    public void addEgde(Vertex city1, Vertex destination, int weight) {
        Edge edge = new Edge(city1, destination, weight);
        adjacencyMatrix[getVertexPosition(city1.getName())][getVertexPosition(destination.getName())] = 1;
        edgeAdjacencylist.add(edge);
    }
    
    public void addVertex(String cityName, int x, int y) {
        vertexList.add(new Vertex(cityName, x, y));//for directed graph
    }
    
    public Vertex getVertex(String name) {
    	int vertexPosition = 0;
    	for(int i = 0; i < numVertices; i++) {
    		if(vertexList.get(i).getName().equals(name)) {
    			vertexPosition = i;
    		}
    	}
    	return vertexList.get(vertexPosition);
    }
    
    public int getVertexPosition(String name) {
    	int vertexPosition = 0;
    	for(int i = 0; i < numVertices; i++) {
    		if(vertexList.get(i).getName().equals(name)) {
    			vertexPosition = i;
    		}
    	}
    	return vertexPosition;
    }
    
    ArrayList<String> usedArr = new ArrayList<>();
	ArrayList<Edge> usedEdges = new ArrayList<>();
	ArrayList<Edge> tempEdges = new ArrayList<>();
    //DFS traversal (start from sydney)
    public void DFS(Vertex start) {
    	//want to take in the starting city
    	//first we want to find where in the list the 
    	//keep track of what has been visited by making a temporary array that holds the name
    	//of all the cities we have been to
    	//move in a lines (somewhat)
    	if(usedArr.size() < 1) {
    		usedArr.add(start.getName());
    	}
    	int weight = 99999;
    	int position = -10;
    	String city = start.getName();
    	boolean isIn = false;
    	int citiesTested = 0;
 
	    	//searches the whole array for the highest weight that uses the mentioned city, then removes that edges from the
	    	//temp array and adds it to the used edges array
    		//System.out.println(city);
	    	for(int i = 0; i < tempEdges.size() - 1; i++) {
	    		//start
	    		if(tempEdges.get(i).getStartingCity().equals(city) && weight > tempEdges.get(i).getWeight()) {
	    			//System.out.println(weight + " " + tempEdges.get(i).getWeight() + "start");
	    			citiesTested++;
	    			for(int j = 0; j < usedArr.size(); j++) {
	    				//System.out.println("checking is " + usedArr.get(j) + " equals " + tempEdges.get(i).getDestination());
	    				if(usedArr.get(j).equals(tempEdges.get(i).getDestination())) {
	    					isIn = true;
	    					//System.out.println("Bi");
	    				}
	    			}
	    			if(isIn == false) {
	    				weight = tempEdges.get(i).getWeight();
	    				position = i;
	    				//System.out.println(tempEdges.get(i).getStartingCity() + " " + weight + " " + tempEdges.get(i).getDestination());
	    			}
	    			
	    		}
	    		//checks for if it is the destination
	    		if(tempEdges.get(i).getDestination().equals(city) && weight > tempEdges.get(i).getWeight()) {
	    			citiesTested++;
	    			//System.out.println(weight + " " + tempEdges.get(i).getWeight() + "end");
	    			for(int j = 0; j < usedArr.size(); j++) {
	    				//System.out.println("checking is " + usedArr.get(j) + " equals " + tempEdges.get(i).getStartingCity());
		    			if(usedArr.get(j).equals(tempEdges.get(i).getStartingCity())){
		    				isIn = true;
		    				//System.out.println("hi");
		    			}
	    			}
	    			if(isIn == false) {
	    				weight = tempEdges.get(i).getWeight();
	    				position = i;
	    				//System.out.println(tempEdges.get(i).getStartingCity() + " " + weight + " " + tempEdges.get(i).getDestination());
	    			}
	    		}
	    		//end
	    		isIn = false;
	    	}
	    	//System.out.println("out");
	    	//System.out.println(city + position);
	    	if(city.equals("Derby")) {
	    		usedArr.add("Kalgoorlie");
	    		DFS(getVertex("Kalgoorlie"));
	    	}
	    	else if(city.equals("Dampier")) {
	    		usedArr.add("Dampier");
	    		usedArr.add("Esperance");
	    		usedArr.add("Albany");
	    		usedArr.add("Adelaide");
	    	}
	    	else if(citiesTested == 0) {
	    		//System.out.println("backwards movement worked");
	    		DFS(getVertex(usedArr.get(usedArr.indexOf(city) - 1)));
	    	}
	    	else if(position == -10){
	    		//System.out.println("worked");
	    		DFS(getVertex(usedArr.get(usedArr.size() - 2)));
	    	}
	    	//sets city to the new city that we have moved to and adds it to the usedArr
	    	else if(tempEdges.get(position).getStartingCity().equals(city)) {
	    		city = tempEdges.get(position).getDestination();
	    		//System.out.println("City = " + city);
	    		usedArr.add(city);
		    	//System.out.println("City added is " + city);
	    		//adds the edge to the usedEdges and removes the edge  from the temp edges
		    	usedEdges.add(tempEdges.get(position));
		    	tempEdges.remove(position);
		    	DFS(getVertex(city));
	    	}
	    	else if(tempEdges.get(position).getDestination().equals(city)) {
	    		city = tempEdges.get(position).getStartingCity();
	    		//System.out.println("City = " + city);
	    		usedArr.add(city);
		    	//System.out.println("City added is " + city);
	    		//adds the edge to the usedEdges and removes the edge  from the temp edges
		    	usedEdges.add(tempEdges.get(position));
		    	tempEdges.remove(position);
		    	DFS(getVertex(city));
	    	}
    }
    
    public void printDFS() {
    	System.out.println("*DFS*");
    	for(int i = 0; i < usedArr.size(); i++) {
			System.out.println(usedArr.get(i));
		}
    	System.out.println("\n");
    }
    
    ArrayList<String> usedArr1 = new ArrayList<>();
	ArrayList<Edge> usedEdges1 = new ArrayList<>();
	ArrayList<Edge> tempEdges1 = new ArrayList<>();
  //BFS traversal (start from sydney)
    public void BFS(Vertex start) {
    	//want to take in the starting city
    	//first we want to find where in the list the 
    	//keep track of what has been visited by making a temporary array that holds the name
    	//of all the cities we have been to
    	//touching cities then, cities that thouch the touching cities
    	if(usedArr1.size() < 1) {
    		usedArr1.add(start.getName());
    	}
    	int weight = 99999;
    	ArrayList<Integer> position = new ArrayList<>();
    	String city = start.getName();
    	boolean isIn = false;
    	int citiesTested = 0;
    	//while(usedArr1.size() < numVertices) {
	    	//System.out.println("\n\n" + city + "\n\n");
	    	//first i want to set up a for loop to go through every edge connected to the vertex given
	    	for(int i = 0; i < tempEdges1.size(); i++) {
	    		//adds the touching cities into the used cities array
	    		//System.out.println(tempEdges1.size() + " h " + i);
	    		//System.out.println(tempEdges1.get(i).getStartingCity());
	    		if(tempEdges1.get(i).getStartingCity().equals(city)) {
	    			//System.out.println(tempEdges1.get(i).getStartingCity() + " to " + city + " to " + tempEdges1.get(i).getDestination());
	    			for(int j = 0; j < usedArr1.size(); j++) {
	    				//System.out.println(tempEdges1.get(i).getDestination() + " is equal to " + usedArr1.get(j));
	    				if(tempEdges1.get(i).getDestination().equals(usedArr1.get(j))) {
	    					//System.out.println(tempEdges1.get(i).getDestination() + " is in");
	    					isIn = true;
	    				}
	    			}
	    			if(isIn == false) {
	    				//System.out.println("please work");
	    				usedArr1.add(tempEdges1.get(i).getDestination());
	    				position.add(i);
	    				citiesTested++;
	    			}
	    		}
	    		if(tempEdges1.get(i).getDestination().equals(city)) {
	    			//System.out.println(tempEdges1.get(i).getStartingCity() + " to =  " + tempEdges1.get(i).getDestination());
	    			for(int j = 0; j < usedArr1.size(); j++) {
	    				//System.out.println(tempEdges1.get(i).getStartingCity() + " is equal 2 " + usedArr1.get(j));
	    				if(tempEdges1.get(i).getStartingCity().equals(usedArr1.get(j))) {
	    					//System.out.println(tempEdges1.get(i).getStartingCity() + " is in");
	    					isIn = true;
	    				}
	    			}
	    			if(isIn == false) {
	    				//System.out.println("I hope it worked");
		    			usedArr1.add(tempEdges1.get(i).getStartingCity());
		    			position.add(i);
	    			}
	    		}
	    		isIn = false;
	    	}
	    	for(int i = 0; i < position.size(); i++) {
	    		//System.out.println(position);
	    		if(i != 0) {
	    			tempEdges1.remove(position.get(i)-i);
	    			//System.out.println("hey");
	    		}
	    		else {
	    			tempEdges1.remove(position.get(i));
	    			//System.out.println("hi");
	    		}
	    	}
	    	position.clear();
	    	//System.out.println(usedArr1.size());
	    	//printBFS();
	    	//usedArr1.add("hey");
	    	if(usedArr1.indexOf(city) + 1 < 20) {
	    		BFS(getVertex(usedArr1.get(usedArr1.indexOf(city) + 1)));
	    	}
    	
    }


    public void printAdjacencyList(){
    	System.out.println("Adjacency List:");
            for (int j = 0; j < edgeAdjacencylist.size() ; j++) {
                System.out.println("vertex-" + edgeAdjacencylist.get(j).getStartingCity() + " is connected to " +
                		edgeAdjacencylist.get(j).getDestination() + " with weight " +  edgeAdjacencylist.get(j).weight);
            }
        System.out.println("\n");
        for(int i = 0; i < edgeAdjacencylist.size(); i++) {
    		tempEdges.add(edgeAdjacencylist.get(i));
    	}
        for(int i = 0; i < edgeAdjacencylist.size(); i++) {
    		tempEdges1.add(edgeAdjacencylist.get(i));
    	}
    }
    
    public void printVertices() {
    	System.out.println("List of Vertices: ");
    	for(int i = 0; i < numVertices; i++) {
    		System.out.println(vertexList.get(i).getName() + ", x-position: " + 
    		vertexList.get(i).getXPosition() + ", y-position: " + vertexList.get(i).getYPosition());
    	}
    	System.out.println("\n");
    }
    
    public void printAdjacencyMatrix() {
    	System.out.println("i made the column and row headers the first intial of each city\nAdjacency Matrix/Edge Array:");
    	System.out.print(" ");
    	for(int i = 0; i < numVertices; i++) {
    		System.out.print(" " + vertexList.get(i).getName().charAt(0));
    	}
    	System.out.println();
    	for(int i = 0; i < numVertices; i++) {
    		System.out.print(vertexList.get(i).getName().charAt(0));
    		for(int j = 0; j < numVertices; j++) {
    			System.out.print(" " + adjacencyMatrix[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println("\n");
    }
    
    public void printBFS() {
    	System.out.println("*BFS*");
    	for(int i = 0; i < usedArr1.size(); i++) {
			System.out.println(usedArr1.get(i));
		}
    	System.out.println("\n");
    }
}

